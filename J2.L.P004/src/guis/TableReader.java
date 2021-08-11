/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guis;

import daos.ReaderDAO;
import dtos.Reader;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author TanNV
 */
public class TableReader extends AbstractTableModel{
    private ArrayList<Reader> data = null;
    private String[] headeres = {"ID","Full name", "Age", "Gender", "Phone", "Address"};
    private int[] indexes = {0,1,2,3,4,5};
    private ReaderDAO dao = null;

    public TableReader() throws SQLException {
        data = new ArrayList<>();
        dao = new ReaderDAO();
    }
    
    public ArrayList<Reader> getData() {
        return data;
    }

    public void setData(ArrayList<Reader> data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
         return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Reader reader = data.get(rowIndex);
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        int age = LocalDate.now().getYear() - Integer.parseInt(format.format(reader.getBirthday()));
        switch(columnIndex){
            case 0 : return reader.getReaderID();
            case 1 : return reader.getReaderName();
            case 2 : return age;
            case 3 : return reader.isGender()?"Male":"Female"; // true = male ; false = female;
            case 4 : return reader.getPhone();
            case 5 : return reader.getAddress();          
        }
        return null;
    }

    @Override
    public String getColumnName(int i) {
        return headeres[i];
    }

    public void loadData() throws SQLException {
        ReaderDAO dao = new ReaderDAO();
        data = dao.getAllReader();
    }
    
    public boolean createReader(Reader reader) throws SQLException{
        return dao.createReader(reader);
    }
    
    public boolean deleteReader(String id) throws SQLException{
        return dao.deleteReader(id);
    }
    
    public boolean updateReader(Reader reader) throws SQLException{
        return dao.updateReader(reader);
    }
    
    public void sort(int az) throws SQLException{
        
        if (az == 0) { // return old data
            ReaderDAO dao = new ReaderDAO();
            this.setData(dao.getAllReader());
        }
        
        Collections.sort(data, new Comparator<Reader>() {
            @Override
            public int compare(Reader t, Reader t1) {
                if (az == 1) { // sort name a-z
                    return t.getReaderName().compareToIgnoreCase(t1.getReaderName());
                }
                if (az == 2) {
                    return t1.getReaderName().compareToIgnoreCase(t.getReaderName());
                }
                return 0;
            }
        });
         
    }
    
}
