package com.example.bikeshopapp.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "parts")
public class Part {
    @PrimaryKey(autoGenerate = true)
    private int partID;
    private String partName;
    private double price;
    private int productID;

    // Constructor

    public Part(int partID, String partName, double price, int productID) {
        this.partID = partID;
        this.partName = partName;
        this.price = price;
        this.productID = productID;
    }

    // Getter

    public int getPartID() {
        return partID;
    }

    public String getPartName() {
        return partName;
    }

    public double getPrice() {
        return price;
    }

    public int getProductID() {
        return productID;
    }

    // Setter


    public void setPartID(int partID) {
        this.partID = partID;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    // toString
    @Override
    public String toString() {
        return "Part{" +
                "partID=" + partID +
                ", partName='" + partName + '\'' +
                ", price=" + price +
                ", productID=" + productID +
                '}';
    }
}
