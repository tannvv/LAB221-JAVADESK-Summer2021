/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.util.Objects;

/**
 *
 * @author TanNV
 */
public class Motocycle {
    private String motocycleID, model, condition, warranty;
    private int year;
    private float price;
    private int quantity;
    private Brand brandID;

    public Motocycle() {
    }

    public Motocycle(String motocycleID) {
        this.motocycleID = motocycleID;
    }

    public Motocycle(String motocycleID, String model, String condition, String warranty, int year, float price, int quantity, Brand brandID) {
        this.motocycleID = motocycleID;
        this.model = model;
        this.condition = condition;
        this.warranty = warranty;
        this.year = year;
        this.price = price;
        this.quantity = quantity;
        this.brandID = brandID;
    }

    public String getMotocycleID() {
        return motocycleID;
    }

    public void setMotocycleID(String motocycleID) {
        this.motocycleID = motocycleID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Brand getBrandID() {
        return brandID;
    }

    public void setBrandID(Brand brandID) {
        this.brandID = brandID;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Motocycle other = (Motocycle) obj;
        if (!Objects.equals(this.motocycleID, other.motocycleID)) {
            return false;
        }
        return true;
    }
    
    
    
}
