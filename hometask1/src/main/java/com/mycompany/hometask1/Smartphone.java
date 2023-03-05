/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.hometask1;




/**
 *
 * 
 */
public class Smartphone extends Telephone{

    private int numberOfMembers;

    public Smartphone(int numberOfMembers, String manufacturer, int callCost, String operator) {
        super(manufacturer, callCost, operator);
        this.numberOfMembers = numberOfMembers;
    }

  
  @Override
    public String toString() {
        String result = " Smartphone:"   + " Manufacturer is " + getManufacturer()  +" , call cost is " + getCallCost() + " dollars"+ " , operator is " +  getOperator() + " , number of members is " + this.numberOfMembers + " people";
        return result;
    }
    
}


   
    
    
