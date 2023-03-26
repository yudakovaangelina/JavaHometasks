/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hometask1_12;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * 
 */
public class LoaderRunnable implements Runnable{
    private String path;

    public LoaderRunnable() {
    }

    public LoaderRunnable(String path) {
        this.path = path;
    }

    @Override
    public void run() {
        FileInputStream fis;
        if (this.path != null && new File(this.path).exists()){
          try{
              fis = new FileInputStream(path);
              ObjectInputStream ois = new ObjectInputStream(fis);
              Message message = (Message)ois.readObject();
              ois.close();
              System.out.println(message.toString());
          }catch (ClassNotFoundException | IOException ex) {
              System.out.println("Error " + ex.getMessage());
          }  
        }
    }
    
   
    
}
