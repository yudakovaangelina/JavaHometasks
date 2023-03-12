/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.hometask18;

import java.util.HashMap;

import java.util.Map.Entry;
import java.util.Scanner;

/**
 *
 * 
 */
public class Hometask18 {

    public static void main(String[] args) {
        System.out.println("Практическое задание 4, вариант 2, Юдакова Ангелина РИБО-02-21");
        System.out.println("Enter number to choose command. 1 - show list of phones, 2 - add new phone, 3 - delete phone, 4 - delete all phones, 5 - end");
        
        
        
        HashMap<Integer,Telephone> phonesMap = new HashMap<>();
        phonesMap.put(12345, new Telephone("Iphone", "white", true));
        phonesMap.put(47099, new Telephone("Huawei", "green", true));
        phonesMap.put(88765, new Telephone("Nokia", "black", false));
        
        Scanner scan = new Scanner(System.in);
        int choose = scan.nextInt();
        
        while (choose != 5){
        
        if (choose ==1){
            
        for(Entry<Integer,Telephone> entr: phonesMap.entrySet()){
            int serialNumber = entr.getKey();
            String colours = entr.getValue().getColour();
            String models = entr.getValue().getModel();
            boolean isMobiles = entr.getValue().isIsMobile();
            System.out.println(models + ", " + serialNumber + ", " + colours + ", " + isMobiles );
            
                
            }
        }
        
        if (choose == 2){
            System.out.println("Enter serial number:");
            int enteredSerialNumbers = scan.nextInt();
            
            for(Entry<Integer,Telephone> entr: phonesMap.entrySet()){
            int serialNumber = entr.getKey();
            
            
            
            while (enteredSerialNumbers == serialNumber ){
                System.out.println("Entered serial number exists, please enter another number:");
                enteredSerialNumbers = scan.nextInt();
            }
            
            }
            System.out.println("Enter model:");
            String models = scan.next();
            
            System.out.println("Enter colour:");
            String colours = scan.next();
            
            System.out.println("Enter is mobile?");
            boolean isMobile = scan.nextBoolean();
            
            
            phonesMap.put(enteredSerialNumbers, new Telephone(models, colours, isMobile));
            
            for(Entry<Integer,Telephone> entr: phonesMap.entrySet()){
            int serialNumber = entr.getKey();
            colours = entr.getValue().getColour();
            models = entr.getValue().getModel();
            boolean isMobiles = entr.getValue().isIsMobile();
            System.out.println(models + ", " + serialNumber + ", " + colours + ", " + isMobiles );
      
            
                }
            
        }
            
        if (choose == 3) {
            System.out.println("enter serial number to delete phone:");
            int delete = scan.nextInt();
            phonesMap.remove(delete);
            
           for(Entry<Integer,Telephone> entr: phonesMap.entrySet()){
            int serialNumber = entr.getKey();
            String colours = entr.getValue().getColour();
            String models = entr.getValue().getModel();
            boolean isMobiles = entr.getValue().isIsMobile();
            System.out.println(models + ", " + serialNumber + ", " + colours + ", " + isMobiles );
            }
        }   
            
        if (choose == 4){
            System.out.println("Deleting.");
            System.out.println("Deleting..");
            System.out.println("Deleting...");
            System.out.println("Complete!");
            phonesMap.clear();
            for(Entry<Integer,Telephone> entr: phonesMap.entrySet()){
            int serialNumber = entr.getKey();
            String colours = entr.getValue().getColour();
            String models = entr.getValue().getModel();
            boolean isMobiles = entr.getValue().isIsMobile();
            System.out.println(models + ", " + serialNumber + ", " + colours + ", " + isMobiles );
            }
            
        }
       
        if (choose == 5) break;
            
        if ((choose > 5) | (choose < 1)){
            System.out.println("This command doesnt exists!");
        }
        
        System.out.println("Enter number to choose command. 1 - show list of phones, 2 - add new phone, 3 - delete phone, 4 - delete all phones, 5 - end");
        
        choose = scan.nextInt();
        
        }
    }
}
    

