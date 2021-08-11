/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.Reader;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import utils.DBUtil;

/**
 *
 * @author TanNV
 */
public class ReaderDAO {

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

    public ArrayList<Reader> getAllReader() throws SQLException {
        ArrayList<Reader> list = null;
        String sql = "SELECT * FROM Reader";
        try {
            conn = DBUtil.getConnect();
            ptsm = conn.prepareStatement(sql);
            rs = ptsm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                String readerID = rs.getString("readerID");
                String readerName = rs.getString("readerName");
                boolean gender = rs.getBoolean("gender");
                Date birthday = rs.getDate("birthday");
                int address = rs.getInt("address");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                Reader reader = new Reader(readerID, readerName, email, phone, gender, birthday, address);
                list.add(reader);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            cleanConnect();
        }
        return list;
    }
    
    public ArrayList<Reader> getReaderName(String name) throws SQLException {
        ArrayList<Reader> list = null;
        String sql = "SELECT * FROM Reader WHERE readerName = ?";
        try {
            conn = DBUtil.getConnect();
            ptsm = conn.prepareStatement(sql);
            ptsm.setString(1, name);
            rs = ptsm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                String readerID = rs.getString("readerID");
                String readerName = rs.getString("readerName");
                boolean gender = rs.getBoolean("gender");
                Date birthday = rs.getDate("birthday");
                int address = rs.getInt("address");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                Reader reader = new Reader(readerID, readerName, email, phone, gender, birthday, address);
                list.add(reader);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            cleanConnect();
        }
        return list;
    }


    public Reader getReaderId(String id) throws SQLException {
        Reader reader = null;
        String sql = "SELECT * FROM Reader WHERE readerID = ?";
        try {
            conn = DBUtil.getConnect();
            ptsm = conn.prepareStatement(sql);
            ptsm.setString(1, id);
            
            rs = ptsm.executeQuery();
            if(rs.next()) {
                String readerID = rs.getString("readerID");
                String readerName = rs.getString("readerName");
                boolean gender = rs.getBoolean("gender");
                Date birthday = rs.getDate("birthday");
                int address = rs.getInt("address");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                reader = new Reader(readerID, readerName, email, phone, gender, birthday, address);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            cleanConnect();
        }
        return reader;
    }

    public boolean createReader(Reader reader) throws SQLException {
        boolean result = false;
        String sql = "INSERT INTO Reader(readerID,readerName,gender,birthday,address,email,phone) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = DBUtil.getConnect();
            ptsm = conn.prepareStatement(sql);

            ptsm.setString(1, reader.getReaderID());
            ptsm.setString(2, reader.getReaderName());
            ptsm.setBoolean(3, reader.isGender());

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String date = format.format(reader.getBirthday());
            ptsm.setString(4, date);

            ptsm.setInt(5, reader.getAddress());
            ptsm.setString(6, reader.getEmail());
            ptsm.setString(7, reader.getPhone());

            ptsm.executeUpdate();
            result = true;

        } catch (Exception ex) {
            result = false;
            ex.printStackTrace();
        } finally {
            cleanConnect();
        }
        return result;
    }

    public boolean updateReader(Reader reader) throws SQLException {
        boolean result = false;
        String sql = "UPDATE Reader \n"
                + "SET readerName = ?, gender = ?, birthday = ?, address = ?, email = ?, phone =?  \n"
                + "WHERE readerID = ?";
        try {
            conn = DBUtil.getConnect();
            ptsm = conn.prepareStatement(sql);

            ptsm.setString(1, reader.getReaderName());
            ptsm.setBoolean(2, reader.isGender());

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String date = format.format(reader.getBirthday());
            ptsm.setString(3, date);

            ptsm.setInt(4, reader.getAddress());
            ptsm.setString(5, reader.getEmail());
            ptsm.setString(6, reader.getPhone());
            ptsm.setString(7, reader.getReaderID());

            ptsm.executeUpdate();
            result = true;

        } catch (Exception ex) {
            result = false;
            ex.printStackTrace();
        } finally {
            cleanConnect();
        }
        return result;
    }

    public boolean deleteReader(String id) throws SQLException {
        boolean result = false;
        String sql = "DELETE FROM Reader WHERE readerID = ?";
        try {
            conn = DBUtil.getConnect();
            ptsm = conn.prepareStatement(sql);

            ptsm.setString(1, id);

            ptsm.executeUpdate();
            result = true;

        } catch (Exception ex) {
            result = false;
            ex.printStackTrace();
        } finally {
            cleanConnect();
        }
        return result;
    }

}
