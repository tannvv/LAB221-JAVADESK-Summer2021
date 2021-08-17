/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.RegistrationDTO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author TanNV
 */
public class RegistrationDAO implements Serializable{
    public static ArrayList<RegistrationDTO> readFile(String fName) {
        ArrayList<RegistrationDTO> listReg = new ArrayList<>();
        FileReader fr = null;
        BufferedReader bf = null;
        try {
            fr = new FileReader(fName);//read
            bf = new BufferedReader(fr);//readline
            String details;
            while ((details = bf.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(details, ",");
                
                String registrationID = stk.nextToken();
                String fullname = stk.nextToken();
                int age = Integer.parseInt(stk.nextToken());
                boolean gender = Boolean.parseBoolean(stk.nextToken());
                String email = stk.nextToken();
                String phone = stk.nextToken();
                String address = stk.nextToken();
                int numberOfPet = Integer.parseInt(stk.nextToken());
                String systoms = stk.nextToken();
                listReg.add(new RegistrationDTO(registrationID, fullname, email, phone, address, systoms, age, numberOfPet, gender));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "can't connect with rmi or file not exists");
        } finally {
            try {
                bf.close();
                fr.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        return listReg;
    }

    public static void writeFile(String fName, ArrayList<RegistrationDTO> listReg) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(fName);
            for (RegistrationDTO x : listReg){
                pw.println(x.toString());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "file not exists");
        } finally {
            pw.close();
        }
    }
}
