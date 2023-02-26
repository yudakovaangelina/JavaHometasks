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
    private String callQuality;
    private int callCost;
    private String operator;
    

    public Telephone() {
    }

    public Telephone(String callQuality, int callCost, String operator) {
        this.callQuality = callQuality;
        this.callCost = callCost;
        this.operator = operator;
    }

    public String getCallQuality() {
        return callQuality;
    }

    public void setCallQuality(String callQuality) {
        this.callQuality = callQuality;
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
