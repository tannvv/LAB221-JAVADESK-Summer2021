/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guis;

import dtos.RegistrationDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author TanNV
 */
public class PetModel extends AbstractTableModel implements Serializable{
    private ArrayList<RegistrationDTO> data = null;
    private String[] headeres = {"ID", "Full name", "Age", "Gender","Phone","Address"};

    public PetModel() {
    }

    public ArrayList<RegistrationDTO> getData() {
        return data;
    }

    public void setData(ArrayList<RegistrationDTO> data) {
        this.data = data;
    }

    
    @Override
    public int getRowCount() {
        if (data == null) {
            return 0;
        }else{
            return data.size();
        }
    }

    @Override
    public int getColumnCount() {
        return headeres.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        RegistrationDTO regis = data.get(row);
        switch(column){
            case 0 : return regis.getRegistrationID();
            case 1 : return regis.getFullName();
            case 2 : return regis.getAge();
            case 3 : return regis.isGender()?"Male":"Female";
            case 4 : return regis.getPhone();
            case 5 : return regis.getAddress();          
        }
        return null;
    }

    @Override
    public String getColumnName(int i) {
        return headeres[i]; //To change body of generated methods, choose Tools | Templates.
    }
    
    public void sort(int az){
        Collections.sort(data, new Comparator<RegistrationDTO>() {
            @Override
            public int compare(RegistrationDTO t, RegistrationDTO t1) {
                if (az == 1) { // a-z
                    return t.getFullName().compareToIgnoreCase(t1.getFullName());
                }else{          // z-a
                    return t1.getFullName().compareToIgnoreCase(t.getFullName());
                }
            }
        });
    }
    
    
    
}
