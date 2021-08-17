/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.io.Serializable;

/**
 *
 * @author TanNV
 */
public class RegistrationDTO implements Serializable{

    private String registrationID, fullName, email, phone, address, symptoms;
    private int age, numberOfPet;
    private boolean gender;

    public RegistrationDTO() {
    }

    public RegistrationDTO(String registrationID, String fullName, String email, String phone, String address, String symptoms, int age, int numberOfPet, boolean gender) {
        this.registrationID = registrationID;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.symptoms = symptoms;
        this.age = age;
        this.numberOfPet = numberOfPet;
        this.gender = gender;
    }

    public String getRegistrationID() {
        return registrationID;
    }

    public void setRegistrationID(String registrationID) {
        this.registrationID = registrationID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumberOfPet() {
        return numberOfPet;
    }

    public void setNumberOfPet(int numberOfPet) {
        this.numberOfPet = numberOfPet;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return registrationID + "," + fullName + "," + age + "," + gender + "," + email + "," + phone + "," + address + "," + numberOfPet + "," + symptoms ;

    }

}
