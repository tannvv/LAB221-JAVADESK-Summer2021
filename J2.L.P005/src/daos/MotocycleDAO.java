/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.Brand;
import dtos.Motocycle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import utils.DBUils;

/**
 *
 * @author TanNV
 */
public class MotocycleDAO {
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

    public ArrayList<Motocycle> getAllMoto() throws SQLException {
        ArrayList<Motocycle> list = null;
        String sql = "SELECT motocycleID,model,year,condition,price,quantity,warranty,brandID FROM TblMotocycle";
        try {
            conn = DBUils.getConnect();
            ptsm = conn.prepareStatement(sql);
            rs = ptsm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                String id = rs.getString("motocycleID");
                String model = rs.getString("model");
                Date year = rs.getDate("year");
                String condition = rs.getString("condition");
                float price = rs.getFloat("price");
                int quantity = rs.getInt("quantity");
                String warranty = rs.getString("warranty");
                String brandID = rs.getString("brandID");
                Motocycle moto = new Motocycle(id, model, condition, warranty, year, price, quantity, new Brand(brandID));
                list.add(moto);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            cleanConnect();
        }
        return list;
    }
    
    public int numberOfMotoByBrandID(String brandID) throws SQLException{
        int result = 0;
        String sql = "SELECT motocycleID FROM TblMotocycle \n"
                + "WHERE brandID = ?";
        try{
            conn = DBUils.getConnect();
            ptsm = conn.prepareStatement(sql);
            ptsm.setString(1, brandID);
            rs = ptsm.executeQuery();
            while (rs.next()) {                
                result++;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            cleanConnect();
        }
        return result;
    }
    
    public boolean createMoto(Motocycle moto) throws SQLException {
        boolean result = false;
        String sql = "INSERT INTO TblMotocycle(motocycleID,model,year,condition,price,quantity,warranty,brandID) \n"
                + "VALUES (?,?,?,?,?,?,?,?)";
        try {
            conn = DBUils.getConnect();
            ptsm = conn.prepareStatement(sql);
            ptsm.setString(1, moto.getMotocycleID());
            ptsm.setString(2, moto.getModel());
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
            String year = dateFormat.format(moto.getYear());
            ptsm.setString(3, year);
            
            ptsm.setString(4, moto.getCondition());
            ptsm.setFloat(5, moto.getPrice());
            ptsm.setInt(6, moto.getQuantity());
            ptsm.setString(7, moto.getWarranty());
            ptsm.setString(8, moto.getBrandID().getBrandID());
            
            if ((ptsm.executeUpdate() == 1)) {
                result = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            cleanConnect();
        }
        return result;
    }
    
    public boolean updateMoto(Motocycle moto) throws SQLException {
        boolean result = false;
        String sql = "UPDATE TblMotocycle \n"
                + "SET model=?,year=?,condition=?,price=?,quantity=?,warranty=?,brandID=? \n"
                + "WHERE motocycleID=?";
        try {
            conn = DBUils.getConnect();
            ptsm = conn.prepareStatement(sql);
       
            ptsm.setString(1, moto.getModel());
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
            String year = dateFormat.format(moto.getYear());
            ptsm.setString(2, year);
            
            ptsm.setString(3, moto.getCondition());
            ptsm.setFloat(4, moto.getPrice());
            ptsm.setInt(5, moto.getQuantity());
            ptsm.setString(6, moto.getWarranty());
            ptsm.setString(7, moto.getBrandID().getBrandID());
            ptsm.setString(8, moto.getMotocycleID());
            
            if ((ptsm.executeUpdate() == 1)) {
                result = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            cleanConnect();
        }
        return result;
    }
    
    public boolean deleteMoto(String id) throws SQLException {
        boolean result = false;
        String sql = "DELETE TblMotocycle WHERE motocycleID=?";
        try {
            conn = DBUils.getConnect();
            ptsm = conn.prepareStatement(sql);
       
            ptsm.setString(1, id);
           
            if ((ptsm.executeUpdate() == 1)) {
                result = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            cleanConnect();
        }
        return result;
    }
}
