/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mirea.kt.example.hometask1_14;

/**
 *
 *
 */
public class Hometask1_14 {

    public static void main(String[] args) {
        System.out.println("Юдакова Ангелина РИБО-02-21 вариант 2, задание 1.14");
        Runnable rn = new StudentsRunnable();
        Thread student1 = new Thread(rn, "Student 1");
        Thread student2 = new Thread(rn, "Student 2");
        Thread student3 = new Thread(rn, "Student 3");
        Thread student4 = new Thread(rn, "Student 4");
        Thread student5 = new Thread(rn, "Student 5");
        Thread student6 = new Thread(rn, "Student 6");
        Thread student7 = new Thread(rn, "Student 7");
       
        student1.start();
        student2.start();
        student3.start();
        student4.start();
        student5.start();
        student6.start();
        student7.start();
       
        
        
    }
}
