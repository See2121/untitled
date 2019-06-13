package more.education.bank.v2.processor;

import java.util.Scanner;

public class AtmProcessor {


    public double processor(double userBalance, Scanner input, String userLogin) {
        byte button;
        double money;
        System.out.println("Welcome, " + userLogin + "! Your balance: " + userBalance);


        do {
            System.out.println("Choose operation:");
            System.out.println("0) exit");
            System.out.println("1) refill");
            System.out.println("2) withdraw");
            System.out.print("> ");
            button = input.nextByte();

            if (button == 1) {
                System.out.println("Enter the amount you want to replenish");
                System.out.print("> ");
                money = input.nextDouble();

                userBalance = refillCount(money, userBalance);


            }
            if (button == 2) {
                System.out.println("Enter the amount to withdraw");
                System.out.print("> ");
                money = input.nextDouble();

                userBalance = withdrawCount(money, userBalance);

            }
        } while (button != 0);
        return userBalance;
    }


    static double refillCount(double money, double balance) {
        if (money <= 0) {
            System.out.println("The amount must be positive");
        } else {
            balance += money;
            System.out.println("Your balance: " + balance);
        }

        return balance;
    }


    static double withdrawCount(double money, double balance) {
        if (money > balance) {

            System.out.println("You cannot withdraw this amount");
        } else {

            balance -= money;
            System.out.println("Your balance: " + balance);

        }
        return balance;
    }


}
