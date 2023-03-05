package com.mycompany.hometask1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 *
 */


public class Telephone {
    private String manufacturer;
    private int callCost;
    private String operator;
    

    public Telephone() {
    }

    public Telephone(String manufacturer, int callCost, String operator) {
        this.manufacturer = manufacturer;
        this.callCost = callCost;
        this.operator = operator;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getCallCost() {
        return callCost;
    }

    public void setCallCost(int callCost) {
        this.callCost = callCost;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }



    
}
