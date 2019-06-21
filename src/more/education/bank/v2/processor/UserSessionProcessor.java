package more.education.bank.v2.processor;

import more.education.bank.v2.model.event.AbstractEvent;
import more.education.bank.v2.model.event.UserFailedLoginEvent;
import more.education.bank.v2.model.event.UserSuccessLoginEvent;
import more.education.bank.v2.service.MonitoringService;
import more.education.bank.v2.model.User;
import more.education.bank.v2.model.UserType;
import more.education.bank.v2.Util;

import java.time.Clock;
import java.time.DateTimeException;
import java.time.Instant;
import java.util.Date;
import java.util.Scanner;

public class UserSessionProcessor {


    private MonitoringService monitoringService;


    public UserSessionProcessor(MonitoringService monitoringService) {
        this.monitoringService = monitoringService;
    }


    public User[] process(User[] users, Scanner input) {

        UserType userType = UserType.CUSTOMER;
        boolean loginOperationResult = false;
        byte choiceOfCorrectPassword = 1;
        String enteredLogin;
        Date trackeddAt;

        User found;
        byte x = 0;

        do {
            String enteredPassword;

            System.out.println("Enter login: ");
            System.out.print("> ");
            enteredLogin = input.next();
            trackeddAt = new Date();

            System.out.println("Enter password: ");
            System.out.print("> ");
            enteredPassword = input.next();


            found = Util.searchUser(users, enteredLogin);


            if (found == null) {
                System.out.println("Incorrect login or password");
                System.out.println("0) Exit");
                System.out.println("1) Try again");
                System.out.println("attempt: " + x + "/2");
                System.out.print("> ");
                monitoringService.logEvent(new UserFailedLoginEvent(enteredLogin,trackeddAt));

                choiceOfCorrectPassword = input.nextByte();
                if (choiceOfCorrectPassword == 0) {
                    break;
                } else {
                    continue;
                }
            }

            if (!found.isActive()) {
                System.out.println("You are not active");
                System.out.println("0) Exit");
                System.out.println("1) Try again");
                choiceOfCorrectPassword = input.nextByte();
                if (choiceOfCorrectPassword == 0) {
                    break;
                } else {
                    continue;
                }
            }
            x++;

            if (!found.getPassword().equals(enteredPassword)) {
                if (x == 3) {
                    found.setActive(false);
                    System.out.println("you are inactive");

                    return users;
                }


                System.out.println("Incorrect login or password");
                System.out.println("0) Exit");
                System.out.println("1) Try again");
                System.out.println("attempt: " + x + "/2");
                System.out.print("> ");

                choiceOfCorrectPassword = input.nextByte();
                if (choiceOfCorrectPassword == 0) {
                    break;
                } else {
                    continue;
                }
            }


            loginOperationResult = true;

        } while (!loginOperationResult);

        if (!loginOperationResult) {

            monitoringService.logEvent(new UserFailedLoginEvent(enteredLogin,trackeddAt));

        }


        if (choiceOfCorrectPassword != 0 && !found.getType().equals(userType)) {

            monitoringService.logEvent(new UserSuccessLoginEvent(enteredLogin,trackeddAt));

            AdminOperationProcessor adminOperation = new AdminOperationProcessor(monitoringService);
            found.setActive(adminOperation.processor(input, users, found.isActive()));
        }


        if (choiceOfCorrectPassword != 0 && found.getType().equals(userType)) {
            monitoringService.logEvent(new UserSuccessLoginEvent(enteredLogin,trackeddAt));


            AtmProcessor atmProcessor = new AtmProcessor();
            found.setBalance(atmProcessor.processor(found.getBalance(), input, found.getLogin()));
        }


        return users;

    }

}

