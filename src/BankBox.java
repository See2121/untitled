import java.util.Scanner;

public class BankBox {
    public static void main(String[] args) {

        int num = 0;
        double balance = 0;
        Scanner input = new Scanner(System.in);

        int m;
        System.out.println("Добрый день. В данный момент ваш баланс: " + balance);
        do {

            do {
                System.out.println("Выберите операцию:");
                System.out.println("0) выход");
                System.out.println("1) пополнение счета");
                System.out.println("2) списание со счета");
                System.out.print("> ");

                m = input.nextInt();
                if (m != 1 && m != 2 && m!=0 ) {
                    System.out.println("Введите запрос снова");

                }
                if (m == 0) {
                    System.out.println("Вы вышли");
                    System.exit(0);

                }
            } while (m == 0);


            if (m == 1) {
                do {

                    System.out.println("Введите сумму на которую желаете пополнить");
                    balance = input.nextDouble();
                    if (balance <= 0) {
                        System.out.println("Сумма должна быть положительной");

                    }


                } while (balance <= 0);
                System.out.println("ваш баланс " + balance);
            }

            if (m == 2) {
                do {
                    System.out.println("Введите сумму которую вы желаете снять");
                    System.out.println("0) выход");
                    num = input.nextInt();

                    if (num > balance || num < 0) {
                        System.out.println("Вы не можете вывести данную сумму");
                    }
                } while (num > balance || num < 0);
                System.out.println("Ваш остаток " + (balance - num));
            }


        }
        while (m != 0) ;


    }
}
