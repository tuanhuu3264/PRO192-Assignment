/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Inputter {

    public static double inputDouble(String a, double condition) {
        boolean flag;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(a);
                double d = sc.nextDouble();
                if (d <= condition) {
                    throw new Exception();
                }
                flag = false;
                return d;
            } catch (Exception e) {
                System.out.println("ERROR FOMAT!!");
                flag = true;
            }
        } while (flag);
        return -1;
    }

    public static String inputNonBlank(String a) {
        String c;
        boolean flag = true;
        do {
            System.out.print(a);
            Scanner sc = new Scanner(System.in);
            c = sc.nextLine().trim();
            if (c == null || c.equals("")) {
                flag = true;
                System.out.println("ERROR INPUT!!");
            } else {
                flag = false;
            }
        } while (flag);
        return c;
    }

    public static String inputPattern(String a, String pattern) {
        String data;

        boolean flag = true;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print(a);
            data = sc.nextLine().trim();
            if (!data.matches(pattern)) {
                flag = true;
                System.out.println("ERROR FOMAT!!");
            } else {
                flag = false;
            }

        } while (flag);
        return data;
    }

}
