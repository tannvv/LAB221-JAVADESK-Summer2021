/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.util.Date;

/**
 *
 * @author TanNV
 */
public class Reader {
    private String readerID, readerName, email, phone;
    private boolean gender;
    private Date birthday;
    private int address;

    public Reader() {
    }

    public Reader(String readerID) {
        this.readerID = readerID;
    }

    public Reader(String readerID, String readerName, String email, String phone, boolean gender, Date birthday, int address) {
        this.readerID = readerID;
        this.readerName = readerName;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
    }

    public String getReaderID() {
        return readerID;
    }

    public void setReaderID(String readerID) {
        this.readerID = readerID;
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Reader{" + "readerID=" + readerID + ", readerName=" + readerName + ", email=" + email + ", phone=" + phone + ", gender=" + gender + ", birthday=" + birthday + ", address=" + address + '}';
    }
    
    
}
