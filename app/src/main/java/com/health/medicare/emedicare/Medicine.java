package com.health.medicare.emedicare;

import java.io.Serializable;


public class Medicine implements Serializable{
    Medicine(String category, String medicineName, String expiryDate, String priceOfTenTablet) {
        this.category = category;
        this.medicineName = medicineName;
        this.expiryDate = expiryDate;
        this.priceOfTenTablet = priceOfTenTablet;
    }

    Medicine() {

    }

    String getMedicineName() {
        return medicineName;
    }

    void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    void setPriceOfTenTablet(String priceOfTenTablet) {
        this.priceOfTenTablet = priceOfTenTablet;
    }

    String getExpiryDate() {
        return expiryDate;
    }

    String getPriceOfTenTablet() {
        return priceOfTenTablet;
    }

    private String medicineName;
    private String expiryDate;
    private String priceOfTenTablet;
    private String category;

    String getCategory() {
        return category;
    }
}
