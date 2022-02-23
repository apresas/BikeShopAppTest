package com.example.bikeshopapp.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "products")
public class Product {
    @PrimaryKey(autoGenerate = true)
    private int productID;

    private String productName;
    private double productPrice;

    // Constructor
    public Product(int productID, String productName, double productPrice) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    // Getters
    public int getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    // Setters
    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}
