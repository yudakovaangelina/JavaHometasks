/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.hometask1_10;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import static jdk.nashorn.internal.objects.NativeArray.reverse;

/**
 *
 *
 */

public class Hometask1_10 {

    public static void main(String[] args) {
        System.out.println("Юдакова Ангелина РИБО-02-21 Вариант 2");
         Scanner scan = new Scanner(System.in);
         
         System.out.println("Введите путь к файлу");
         String path = scan.nextLine();
         System.out.println("Введите имя файла"); 
         String fileName = scan.nextLine();
         
         File firstFile = new File(path, fileName);
         ArrayList<String> reversedLines = new ArrayList<>();
         try {
           Scanner reading = new Scanner(firstFile);
           
           
           while (reading.hasNextLine()){
            String line = reading.nextLine();  
            int stringLength = line.length();
            String result = "\n";
        for (int i = 0; i < stringLength; i++) {
            result = line.charAt(i) + result;
        }
            reversedLines.add(result);
            
           }
           reading.close();
           } catch (IOException ex) {
                   System.out.println("Произошла ошибка: " + ex.getMessage());
                   
              
    }
          File secondFile = new File(path + "/secondfile.txt");
          
       try {
           FileWriter fw = new FileWriter(secondFile);
           for (String str : reversedLines){
               fw.write(str);
           }
           fw.close();
       }catch(IOException ex){
           System.out.println("Произошла ошибка: " +ex.getMessage());
       }
    }
}
