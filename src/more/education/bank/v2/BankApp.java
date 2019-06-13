package more.education.bank.v2;

import more.education.bank.v2.processor.UserRegistrationProcessor;
import more.education.bank.v2.processor.UserSessionProcessor;

import java.util.Arrays;
import java.util.Scanner;

public class BankApp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        User[] users = new User[]{new User(
                "admin", "admin", 0, true, UserType.ADMIN
        )};

        int num;

        System.out.println(Arrays.deepToString(users));

        do {

            System.out.println("Select an action:");
            System.out.println("1) user authorization");
            System.out.println("2) user registration");
            System.out.println("0) exit");
            System.out.print("> ");

            num = input.nextInt();

            if (num == 1) {
                UserSessionProcessor userSessionProcessor = new UserSessionProcessor();
                users = userSessionProcessor.process(users, input);

            }


            if (num == 2) {
                UserRegistrationProcessor userRegistrationProcessor = new UserRegistrationProcessor();
                users = userRegistrationProcessor.process(users, input);
            }
        } while (num != 0);

        System.out.println("Good bye");
    }
}



