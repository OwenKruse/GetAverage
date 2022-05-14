package com.company;

public class betTest extends Main{

    static double total(double bet, double betAmount, double[] arr) {
        double money = 1000;
        for (int i = 0; i < arr.length; i++) {
            //convert betAmount to percent
            double percent = betAmount / 100;

            //calculate the bet
            double amountToBet = percent * money;

            if (arr[i] >= bet) {
                money -= amountToBet;
                money += (bet * amountToBet);
            } else {
                money -= amountToBet;
            }
        }
        return money;
    }
}
