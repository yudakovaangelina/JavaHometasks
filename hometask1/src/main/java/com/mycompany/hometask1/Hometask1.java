/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.hometask1;

import java.util.Scanner;

/**
 *
 * 
 */
public class Hometask1 {

    
    public static void main(String[] args) {
       Telephone phone = new Telephone();
       
       Seller sell = new Seller();
       
       
       Scanner scan = new Scanner(System.in);
        
       System.out.println("Юдакова Ангелина РИБО-02-21 вариант 2");
       
       System.out.println("Choose your type, enter 1 for button telephone, 0 for smartphone");
       
       int choose = scan.nextInt();
       
       if (choose == 1){
           
       System.out.println("Enter call cost");
       int cost = scan.nextInt();  
       
       System.out.println("Enter call duration");
       int duration = scan.nextInt();
       
       
       System.out.println("Enter operator");
       String oper = scan.next();
       
       System.out.println("Enter manufacturer");
       String manufacture = scan.next();
       
       
       ButtonTelephone firstsub = new ButtonTelephone(duration, manufacture, cost, oper);
       sell.modify(firstsub);
       firstsub.setCallCost(cost);
      
       firstsub.setOperator(oper);
       
       
       
        String res = firstsub.toString();
        System.out.println(res);
       }
        
      if (choose == 0){
       System.out.println("Enter call cost");
       int cost = scan.nextInt();  
       
       System.out.println("Enter number of members");
       int members = scan.nextInt();
       
       
       System.out.println("Enter operator");
       String oper = scan.next();
       
       System.out.println("Enter call manufacturer");
       String manufacture = scan.next();
       
       Smartphone secondsub = new Smartphone(members, manufacture, cost, oper);
       sell.modify(secondsub);
       secondsub.setCallCost(cost);
      
       secondsub.setOperator(oper);
       
        String res = secondsub.toString();
        System.out.println(res);
          
      }
        
    }
       
      
}
