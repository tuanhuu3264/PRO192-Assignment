/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Menu {
     public static int Menu() {
      
        int choice=0;
        boolean flag=true;
        do {
            System.out.println("1- List all brands");
            System.out.println("2- Add a new brands");
            System.out.println("3- Search a brand based on its ID");
            System.out.println("4- Update a brand");
            System.out.println("5- Save brands to the file, named brands.txt");
            System.out.println("6- List all cars in ascending order of brand names");
            System.out.println("7- List cars based on a part of an input brand name");
            System.out.println("8- Add a car");
            System.out.println("9- Remove a car based on its ID");
            System.out.println("10- Update a car based on its ID");
            System.out.println("11- Save cars to file, named cars.txt");
            System.out.println("12- Quit");
            try {
                Scanner ic = new Scanner(System.in);
                System.out.println("Your choice: "); 
                choice= ic.nextInt(); 
                if((choice > 12) && (choice < 1)) throw new Exception();
                flag=false;
            } catch (Exception e) {
                System.out.println("ERROR CHOICE!!!");
                flag= true;
            }

        } while (flag);
        return choice;
    }
    
}
