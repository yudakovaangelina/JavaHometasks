/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hometask18;

/**
 *
 *
 */
public class Telephone {
    private String model;
    private String colour;
    private boolean isMobile;

    public Telephone(String model, String colour, boolean isMobile) {
        this.model = model;
        this.colour = colour;
        this.isMobile = isMobile;
    }

    public Telephone() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public boolean isIsMobile() {
        return isMobile;
    }

    public void setIsMobile(boolean isMobile) {
        this.isMobile = isMobile;
    }
    
    

   
    
    
}
