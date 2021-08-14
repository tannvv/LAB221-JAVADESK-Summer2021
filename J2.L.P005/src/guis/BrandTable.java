/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guis;

import daos.BrandDAO;
import dtos.Brand;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author TanNV
 */
public class BrandTable extends AbstractTableModel{
    private ArrayList<Brand> data = null;
    private String[] headeres = {"Brand ID", "Brand name", "Country", "Description"};

    public BrandTable() throws SQLException {
        loadData();
    }
    
    public ArrayList<Brand> getData() {
        return data;
    }

    public void setData(ArrayList<Brand> data) {
        this.data = data;
    }

    public String[] getHeaderes() {
        return headeres;
    }

    public void setHeaderes(String[] headeres) {
        this.headeres = headeres;
    }
    
    
    @Override
    public int getRowCount() {
        return data.size(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return headeres.length; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int row, int column) {
        Brand brand = data.get(row);
        switch(column){
            case 0 : return brand.getBrandID();
            case 1 : return brand.getBrandName();
            case 2 : return brand.getCountry();
            case 4 : return brand.getDescription();
        }
        return null;
    }

    @Override
    public String getColumnName(int i) {
        return headeres[i]; //To change body of generated methods, choose Tools | Templates.
    }
    
    public void loadData() throws SQLException{
        BrandDAO dao = new BrandDAO();
        this.setData(dao.getAllBrand());
    }
    
    public void createBrand(Brand brand) throws SQLException{
        BrandDAO dao = new BrandDAO();
        boolean check = dao.createBrand(brand);
        if (check) {
            this.getData().add(brand);
        }
    }
    
     public void updateBrand(Brand brand) throws SQLException{
        BrandDAO dao = new BrandDAO();
        boolean check = dao.updateBrand(brand);
        if (check) {
            int index = this.getData().indexOf(brand);
            this.getData().set(index, brand);
        }
    }
     
    public void deleteBrand(String id) throws SQLException{
        BrandDAO dao = new BrandDAO();
        boolean check = dao.deleteBrand(id);
        if (check) {
            int index = this.getData().indexOf(new Brand(id));
            this.getData().remove(index);
        }
    }
}
