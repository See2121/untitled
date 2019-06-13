package more.education.bank.v2.processor;

import more.education.bank.v2.User;
import more.education.bank.v2.UserType;
import more.education.bank.v2.Util;

import java.util.Scanner;

public class UserSessionProcessor {

    public User[] process(User[] users, Scanner input) {

        UserType userType = UserType.CUSTOMER;
        boolean loginOperationResult = false;
        byte choiceOfCorrectPassword = 1;

        User found;
        byte x = 0;

        do {
            String enteredLogin;
            String enteredPassword;

            System.out.println("Enter login: ");
            System.out.print("> ");
            enteredLogin = input.next();

            System.out.println("Enter password: ");
            System.out.print("> ");
            enteredPassword = input.next();

            found = Util.searchUser(users,enteredLogin);


            if (found == null) {
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


                    for (int i = 0; i < users.length; i++) {
                        if (enteredLogin.equals(users[i].getLogin())) {
                            users[i].setActive(false);
                        }
                    }

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


        if (choiceOfCorrectPassword != 0 && !found.getType().equals(userType)) {
            AdminOperation adminOperation = new AdminOperation();
            found.setActive(adminOperation.processor(input, users, found.isActive()));
        }


        if (choiceOfCorrectPassword != 0 && found.getType().equals(userType)) {
            AtmProcessor atmProcessor = new AtmProcessor();
            found.setBalance(atmProcessor.processor(found.getBalance(), input, found.getLogin()));
        }


        return users;
    }


}

