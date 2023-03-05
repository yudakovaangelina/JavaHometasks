/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hometask1;

/**
 *
 * 
 */
public class Seller {
    public void modify(Telephone phone){
        
        String changeManufacturer = phone.getManufacturer();
        char compare1 = 'N';
        char compare2 = 'n';
        char compare3 = changeManufacturer.charAt(0);
        if((compare1 == compare3) || (compare2 == compare3)){
        
        changeManufacturer = changeManufacturer.replace('o', 'a');
        phone.setManufacturer(changeManufacturer);
    }else{
        changeManufacturer = changeManufacturer.toLowerCase();
        changeManufacturer = changeManufacturer.replace('o', 'a');
        phone.setManufacturer(changeManufacturer);
        }
            
            
            
        
        
        
         
        
        
        
                
        
    }

    public Seller() {
    }
}
