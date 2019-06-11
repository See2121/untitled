package more.education.bank.v2;

public class AtmOperation {


    public double refillCount(double money, double balance) {
        if (money <= 0) {
            System.out.println("The amount must be positive");
        } else {
            balance += money;
            System.out.println("Your balance: " + balance);
        }

        return balance;
    }


    public double withdrawCount(double money, double balance) {
        if (money > balance) {

            System.out.println("You cannot withdraw this amount");
        } else {

            balance -= money;
            System.out.println("Your balance: " + balance);

        }
        return balance;
    }


}
