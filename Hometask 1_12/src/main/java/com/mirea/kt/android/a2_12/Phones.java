package com.mirea.kt.android.a2_12;

public class Phones {
    private String model;
    private String serialNumber;
    private int price;


    public Phones(String model, String serialNumber, int price) {
        this.model = model;
        this.serialNumber = serialNumber;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
