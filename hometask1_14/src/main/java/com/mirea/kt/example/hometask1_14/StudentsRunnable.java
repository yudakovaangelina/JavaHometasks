/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mirea.kt.example.hometask1_14;

import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;

/**
 *
 * 
 */
public class StudentsRunnable extends Thread implements Runnable{
    private int freeSeats = 0;
    private Semaphore semaphore = new Semaphore(2);

    
    
    

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " waiting");
        try {
            while ((freeSeats <3) && (!isInterrupted())){
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " eating ");
                sleep(3000);
                System.out.println(Thread.currentThread().getName() + " exit ");
                semaphore.release();
                freeSeats++;
                Thread.currentThread().interrupt();
            }
        }
    catch(InterruptedException e){
    
}
    }   
    
}
