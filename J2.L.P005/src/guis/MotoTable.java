/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guis;

import daos.MotocycleDAO;
import dtos.Motocycle;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author TanNV
 */
public class MotoTable extends AbstractTableModel{
    private Vector<Motocycle> data = null;
    private String[] headeres = {"ID", "Model","Year", "Condition","Price", "Quantity", "Warranty","Brand ID" };

    public MotoTable() throws SQLException {
        loadData();
    }
    
    

    public Vector<Motocycle> getData() {
        return data;
    }

    public void setData(Vector<Motocycle> data) {
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
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return headeres.length; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int row, int column) {
        Motocycle moto = data.get(row);
        switch(column){
            case 0 : return moto.getMotocycleID();
            case 1 : return moto.getModel();
            
            case 2 : return moto.getYear();
                
            case 3 : return moto.getCondition();
            case 4 : return moto.getPrice();
            case 5 : return moto.getQuantity();
            case 6 : return moto.getWarranty();
            case 7 : return moto.getBrandID().getBrandID();        
        }
        return null;
    }

    @Override
    public String getColumnName(int i) {
        return headeres[i]; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    public void createMoto(Motocycle moto) throws SQLException{
        MotocycleDAO dao = new MotocycleDAO();
        boolean check = dao.createMoto(moto);
        if (check) {
            this.getData().add(moto);
        }
    }
    
      public void updateMoto(Motocycle moto) throws SQLException{
        MotocycleDAO dao = new MotocycleDAO();
        boolean check = dao.updateMoto(moto);
        if (check) {
            int index = this.getData().indexOf(moto);
            this.getData().set(index, moto);
        }
    }
    
    public void deleteMoto(String id) throws SQLException{
        MotocycleDAO dao = new MotocycleDAO();
        boolean check = dao.deleteMoto(id);
        if (check) {
            int index = this.getData().indexOf(new Motocycle(id));
            this.getData().remove(index);
        }
    }
    
    private void loadData() throws SQLException{
        MotocycleDAO dao = new MotocycleDAO();
        this.setData(dao.getAllMoto());
    }
}
