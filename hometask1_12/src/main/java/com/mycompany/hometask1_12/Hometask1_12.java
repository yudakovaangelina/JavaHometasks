/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.hometask1_12;

import java.util.Scanner;

/**
 *
 * 
 */
public class Hometask1_12 {

    public static void main(String[] args) {
        System.out.println("Eneter path ");
        Scanner scan = new Scanner(System.in);
        String enteredPath = scan.nextLine();
        LoaderRunnable lr = new LoaderRunnable( enteredPath);
        Thread th = new Thread(lr);
        th.start();
    }
}
