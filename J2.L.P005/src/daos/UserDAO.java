/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.DBUils;

/**
 *
 * @author TanNV
 */
public class UserDAO {
    Connection conn = null;
    PreparedStatement ptsm = null;
    ResultSet rs = null;

    private void cleanConnect() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (ptsm != null) {
            ptsm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
    
    public User checkLogin(String userID, String password) throws SQLException{
        User user = null;
        String sql = "SELECT userID,fullName,password,status FROM TblUser\n"
                + "WHERE userID =? AND password = ?";
        try{
            conn = DBUils.getConnect();
            ptsm = conn.prepareStatement(sql);
            ptsm.setString(1, userID);
            ptsm.setString(2, password);
            rs = ptsm.executeQuery();
            if (rs.next()) {
                user = new User(rs.getString("userID"),rs.getString("password"), rs.getString("fullName"), rs.getBoolean("status"));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            cleanConnect();
        }
        return user;
    }
}
