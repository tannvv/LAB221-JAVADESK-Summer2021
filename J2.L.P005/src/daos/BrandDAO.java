/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.Brand;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import utils.DBUils;

/**
 *
 * @author TanNV
 */
public class BrandDAO {

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

    public Vector<Brand> getAllBrand() throws SQLException {
        Vector<Brand> list = null;
        String sql = "SELECT brandID,brandName,country,description FROM TblBrand";
        try {
            conn = DBUils.getConnect();
            ptsm = conn.prepareStatement(sql);
            rs = ptsm.executeQuery();
            list = new Vector<>();
            while (rs.next()) {
                String brandID = rs.getString("brandID");
                String brandName = rs.getString("brandName");
                String country = rs.getString("country");
                String desc = rs.getString("description");
                Brand brand = new Brand(brandID, brandName, country, desc);
                list.add(brand);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            cleanConnect();
        }
        return list;
    }

    public boolean createBrand(Brand brand) throws SQLException {
        boolean result = false;
        String sql = "INSERT INTO TblBrand(brandID,brandName,country,description) VALUES (?,?,?,?)";
        try {
            conn = DBUils.getConnect();
            ptsm = conn.prepareStatement(sql);
            ptsm.setString(1, brand.getBrandID());
            ptsm.setString(2, brand.getBrandName());
            ptsm.setString(3, brand.getCountry());
            ptsm.setString(4, brand.getDescription());
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

    public boolean updateBrand(Brand brand) throws SQLException {
        boolean result = false;
        String sql = "UPDATE TblBrand \n"
                + "SET brandName = ? , country = ?, description = ? \n"
                + "WHERE brandID = ?";
        try {
            conn = DBUils.getConnect();
            ptsm = conn.prepareStatement(sql);
            ptsm.setString(1, brand.getBrandName());
            ptsm.setString(2, brand.getCountry());
            ptsm.setString(3, brand.getDescription());
            ptsm.setString(4, brand.getBrandID());
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
    
     public boolean deleteBrand(String id) throws SQLException {
        boolean result = false;
        String sql = "DELETE FROM TblBrand WHERE brandID = ?";
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
