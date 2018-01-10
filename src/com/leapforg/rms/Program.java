/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapforg.rms;

import com.leapforg.rms.util.Manager;
import java.util.Scanner;

/**
 *
 * @author HP B&O
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] items = {"Momo", "Chowmein", "Fried rice"};

        Scanner input = new Scanner(System.in);
        //Setting price and quantity

        Manager manager = new Manager(items, input);
        manager.setUp();
        //
        while (true) {
            manager.menu();

            switch (input.nextInt()) {
                case 1:
                    manager.printItems();
                    System.out.println("Press any key to go back to menu");
                    input.next();
                    break;
                case 2:
                    manager.takeOrder();
                    break;
                case 3:
                    manager.salesReport();
                    break;
                case 5:
                    System.exit(0);
                    break;

            }
        }

    }

}
