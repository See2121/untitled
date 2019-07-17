package more.education.bank.v2.processor;

import more.education.bank.v2.api.service.MonitoringService;
import more.education.bank.v2.model.User;
import more.education.bank.v2.model.UserType;
import more.education.bank.v2.model.event.UserRegisteredEvent;

import java.util.Date;
import java.util.Scanner;

public class UserRegistrationProcessor {

    Date trackeddAt;

    private MonitoringService monitoringService;


    public UserRegistrationProcessor(MonitoringService monitoringService) {
        this.monitoringService = monitoringService;

    }


    static User checkForUniqueness(User[] users, String login, User newUser) {
        int i;

        for (i = 0; i < users.length; i++) {
            newUser = new User();
            if (users[i].getLogin().equals(login)) {
                return null;
            } else {
                newUser.setLogin(login);
            }
        }

        return newUser;
    }


    public User[] process(User[] users, Scanner input) {
        User newUser = new User();

        String password;
        String passwordConfirmation;
        String login;

        do {
            System.out.print("Enter login: ");
            login = input.next();
            trackeddAt = new Date();

            newUser = checkForUniqueness(users, login, newUser);


            if (newUser == null) {
                System.out.println("login exists");
            }

        } while (newUser == null);


        do {
            System.out.print("Enter password: ");
            password = input.next();

            System.out.print("Confirm password: ");
            passwordConfirmation = input.next();

            if (!passwordConfirmation.equals(password)) {
                System.out.println("Password doesn't match");
            }

        } while (!passwordConfirmation.equals(password));


        monitoringService.logEvent(new UserRegisteredEvent(login, trackeddAt));


        newUser.setPassword(password);
        newUser.setActive(true);
        newUser.setType(UserType.CUSTOMER);
        newUser.setBalance(0);

        User[] updatedArray = new User[users.length + 1];

        for (int i = 0; i < users.length; i++) {
            updatedArray[i] = users[i];
        }

        updatedArray[updatedArray.length - 1] = newUser;

        users = updatedArray;

        User.printArray(users);

        return users;


    }


}