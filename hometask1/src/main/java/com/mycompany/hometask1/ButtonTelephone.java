/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hometask1;

/**
 *
 *
 */
public class ButtonTelephone extends Telephone{

    private int callDuration;

    public ButtonTelephone(int callDuration, String manufacturer, int callCost, String operator) {
        super(manufacturer, callCost, operator);
        this.callDuration = callDuration;
    }
    
    

   @Override
    public String toString() {
        String result = " Button Telephone:"  + " Manufacturer is " + getManufacturer()  +" , call cost is " + getCallCost() + " dollars"+ " , operator is " +  getOperator() + " , call duration is " + this.callDuration + " minutes";
        return result;
    }
    
}
