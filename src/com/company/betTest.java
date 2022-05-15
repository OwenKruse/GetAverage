package com.company;

import java.io.IOException;

public class betTest extends Main{

    static double total(double bet, double betAmount, double[] arr, double money) {
        double amount = betAmount;

        for (int i = 0; i < arr.length; i++) {

            //convert betAmount to percent
            if (arr[i] >= bet) {
                money -= amount;
                money += (bet * amount);
                amount = betAmount;
            } else {
                money -= amount;
                if (money > amount * 2) {
                amount = amount * 2;
                }
            }

        }

        return money;
    }
    static double[] best(int n, double[] arr1) throws IOException {
        double temp = 0;

        double[] arr = new double[3];
        for (int i = 0; i < n; i++) {


            double bet = (Math.random() * 10) + 1;
            //round to 3 decimal places
            bet = Math.round(bet * 1000.0) / 1000.0;
            double betAmount = (Math.random() * 10) + 1;
            //round to 3 decimal places
            betAmount = Math.round(betAmount * 1000.0) / 1000.0;
            double out = (Math.random() * 15) + 1;
            //round to 3 decimal places
            out = Math.round(out * 1000.0) / 1000.0;


             if (Double.compare(total(bet, betAmount, Main.afterN(arr1, out), 1000), temp) < 0) {
                 int empty = 0;
             }
             else {
                 System.out.println("bet: " + bet + " betAmount: " + betAmount + " out: " + out);
                temp = total(bet, betAmount, Main.afterN(arr1, out), 1000);
                arr[0] = bet;
                arr[1] = betAmount;
                arr[2] = out;
                 System.out.println("The best bet is: " + total(bet, betAmount, Main.afterN(arr1, out), 1000));
             }
        }

        return arr;
    }

}
