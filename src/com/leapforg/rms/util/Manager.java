/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapforg.rms.util;

import java.util.Scanner;

/**
 *
 * @author HP B&O
 */
public class Manager {

    private String[] items;
    private int[] price, quantity, orders;
    private Scanner input;

    public Manager(String[] items, Scanner input) {
        this.items = items;
        price = new int[items.length];
        quantity = new int[items.length];
        orders = new int[items.length];
        this.input = input;
    }

    public void setUp() {
        for (int i = 0; i < items.length; i++) {
            System.out.println("Enter the price for " + items[i]);
            price[i] = input.nextInt();
            System.out.println("Enter the available quantity for " + items[i]);
            quantity[i] = input.nextInt();
        }
    }

    public void menu() {
        System.out.println("1. Print Items");
        System.out.println("2. Take order");
        System.out.println("3. Show sales report");
        System.out.println("4. Show Avaiable Quantities");
        System.out.println("5. Exit");
        System.out.println("Ente ryour choice[1-5]:");
    }

    public void printItems() {
        System.out.println("Print Items");
        System.out.println("------------------------");
        System.out.println("S.No.\t Item Name\t Price\t Quantity");
        System.out.println("---------------------------");
        for (int i = 0; i < items.length; i++) {
            System.out.println((i + 1) + "\t" + items[i] + "\t" + price[i] + "\t" + quantity[i]);
        }
    }

    public void takeOrder() {
        printItems();
        int ch = 0;
        String params = "";
        String qtyparams = "";
        while (true) {
            while (true) {
                System.out.println("Enter your choice:");
                ch = input.nextInt();
                if (params.equals("")) {
                    params = ch + "";
                } else {
                    params = params + "," + ch + "";
                }
                if (ch >= (items.length + 1) || ch < 1) {
                    System.out.println("Invaild choice");
                } else {
                    break;
                }
            }
            int index = ch - 1;
            System.out.println("Order for " + items[index]);
            System.out.println("Price for " + price[index]);

            while (true) {
                System.out.println("Enter quantity:");
                int qty = input.nextInt();
                if (qtyparams.equals("")) {
                    qtyparams = qty + "";
                } else {
                    qtyparams = qtyparams + "," + qty + "";
                }
                int availablle = quantity[index] - orders[index];
                if (qty > availablle) {
                    System.out.println("Not enough quantity");
                    System.out.println("We have only " + availablle);
                } else {
                    orders[index] += qty;
                    break;
                }
            }

            System.out.println("Do you want to order another?[Y/N]");
            if (input.next().equalsIgnoreCase("n")) {
                break;
            }

        }
        //
        String[] itemTokens = params.split(",");
        String[] qtyTokens = qtyparams.split(",");
        System.out.println("Your orders are: ");
        int grandTotal = 0;
        for (int i = 0; i < itemTokens.length; i++) {
            int x = Integer.parseInt(itemTokens[i]) - 1;
            int q = Integer.parseInt(qtyTokens[i]);
            System.out.println(items[x]);
            System.out.println("Quantity " + q);;
            int total = price[x] * q;
            System.out.println("Price: " + total);
            grandTotal += total;
        }
        System.out.println("-------------------------");
        System.out.println("Total:" + grandTotal);
    }

    public void salesReport() {
        System.out.println("Sales Report");
        System.out.println("--------------------");
        System.out.println("Item \tPrice \tSold \tTotal");
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i] + "\t" + price[i] + "\t" + orders[i] + "\t" + price[i] * orders[i]);
        }
    }

}
