/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author TanNV
 */
public class Brand {
    private String brandID, brandName, country, description;

    public Brand() {
    }

    public Brand(String brandID) {
        this.brandID = brandID;
    }

    public Brand(String brandID, String brandName, String country, String description) {
        this.brandID = brandID;
        this.brandName = brandName;
        this.country = country;
        this.description = description;
    }

    public String getBrandID() {
        return brandID;
    }

    public void setBrandID(String brandID) {
        this.brandID = brandID;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Brand other = (Brand) obj;
        if (!Objects.equals(this.brandID, other.brandID)) {
            return false;
        }
        return true;
    }
    
}
