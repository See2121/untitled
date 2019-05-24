import java.util.Scanner;

public class BankBox {
    public static void main(String[] args) {

        // double num ;
        double balance = 0;
        Scanner input = new Scanner(System.in);
        int m;
        System.out.println("Добрый день. В данный момент ваш баланс: "+balance);
        do {

            double num;

            System.out.println("Выберите операцию:");
            System.out.println("0) выход");
            System.out.println("1) пополнение счета");
            System.out.println("2) списание со счета");
            System.out.print("> ");

            m = input.nextInt();
            if (m != 1 && m != 2 && m != 0) {
                System.out.println("Введите запрос снова");
            }

            if (m == 1) {

                do {
                    System.out.println("Введите сумму на которую желаете пополнить");
                    System.out.println("0) выход");
                    System.out.print("> ");
                    num = input.nextDouble();

                    if (num < 0) {
                        System.out.println("Сумма должна быть положительной");
                        if (num == 0) {
                            System.out.println("Вы вышли");
                        }
                    } else {
                        balance += num;
                    }
                } while (num < 0 && num == 0);
                System.out.println("ваш баланс " + balance);

            }

            if (m == 2) {

                do {
                    System.out.println("Введите сумму которую вы желаете снять");
                    System.out.println("0) выход");
                    System.out.print("> ");
                    num = input.nextDouble();


                    if (num < 0 || num > balance) {
                        System.out.println("Вы не можете вывести данную сумму");
                        System.out.println("Ваш баланс: " + balance);
                    }
                    if (num == 0) {
                        System.out.println("Вы вышли");
                    } else {
                        balance = balance - num;
                    }
                } while (num > balance || num < 0 && num == 0);
                System.out.println("Ваш остаток " + balance);
            }

        }
        while (m != 0);

    }


}

