package more.education.bank.v2;

import more.education.bank.v2.model.User;
import more.education.bank.v2.model.UserType;
import more.education.bank.v2.processor.UserRegistrationProcessor;
import more.education.bank.v2.processor.UserSessionProcessor;
import more.education.bank.v2.service.MonitoringService;

import java.util.Scanner;

public class BankApp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MonitoringService monitoringService = new MonitoringService();
        User[] users = new User[]{new User(
                "admin", "admin", 0, true, UserType.ADMIN
        )};


        int num;


        do {
            System.out.println("Select an action:");
            System.out.println("1) user authorization");
            System.out.println("2) user registration");
            System.out.println("0) exit");
            System.out.print("> ");

            num = input.nextInt();


            if (num == 1) {
                UserSessionProcessor userSessionProcessor = new UserSessionProcessor(monitoringService);
                users = userSessionProcessor.process(users, input);
            }


            if (num == 2) {
                UserRegistrationProcessor userRegistrationProcessor = new UserRegistrationProcessor(monitoringService);
                users = userRegistrationProcessor.process(users, input);

            }


        } while (num != 0);

        System.out.println("Good bye");

    }
}



