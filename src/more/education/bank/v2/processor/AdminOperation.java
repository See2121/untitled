package more.education.bank.v2.processor;

import more.education.bank.v2.User;
import more.education.bank.v2.UserType;

import java.util.Scanner;

class AdminOperation {

    public boolean processor(Scanner input, User[] users, boolean status) {
        System.out.println("Welcome admin");
        byte choiceOfAdminOperations;
        String choice;

        do {

            System.out.println("0) Exit");
            System.out.println("1) print users");
            System.out.println("2) correct status of user");
            System.out.print("> ");
            choiceOfAdminOperations = input.nextByte();

            if (choiceOfAdminOperations == 1) {

                int i;
                AdminOperation.printTable();

                for (i = 0; i < users.length; i++) {
                    AdminOperation.printUsers(users[i].getLogin(), users[i].getBalance(), users[i].getType(), users[i].isActive());
                }

                System.out.format("+============+==========+==========+======+%n");
                System.out.println("Total users: " + i);


            }


            if (choiceOfAdminOperations == 2) {

                System.out.println("Select the user you would like to change status: ");
                User.printUsers(users);
                choice = input.next();

                for (int i = 0; i < users.length; i++) {

                    users[i].setActive(AdminOperation.usersStatus(users[i].isActive(), choice, users[i].getLogin()));

                }

            }

        } while (choiceOfAdminOperations != 0);


        return status;
    }


    static void printTable() {
        System.out.println("Users:");
        System.out.format("+============+==========+==========+======+%n");
        System.out.format("| Username   | Balance  | Type     |Status|%n");
        System.out.format("+============+==========+==========+======+%n");
    }


    static void printUsers(String login, double balance, UserType type, boolean status) {
        System.out.format("|%-12s|%-10s|%-10s|%-6s|%n", login, balance, type, status);
    }


    static boolean usersStatus(boolean status, String choice, String login) {
        if (choice.equals(login)) {
            if (status == true) {
                status = false;
            } else {
                status = true;
            }
        }

        return status;
    }
}
