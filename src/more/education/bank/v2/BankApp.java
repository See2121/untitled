package more.education.bank.v2;

import java.util.Arrays;
import java.util.Scanner;

public class BankApp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        User[] users = new User[]{new User(
                "admin", "admin", 0, true, UserType.ADMIN
        )};


        AtmOperation bnk = new AtmOperation();
        AdminOperation admin = new AdminOperation();
        RegOfUsers regOfUsers = new RegOfUsers();
        UserType userType = UserType.CUSTOMER;

        int num;

        System.out.println(Arrays.deepToString(users));


        do {
            String login, password, passwordConfirmation;


            System.out.println("Select an action:");
            System.out.println("1) user authorization");
            System.out.println("2) user registration");
            System.out.println("0) exit");
            System.out.print("> ");

            boolean loginOperationResult = false;
            byte choiceOfCorrectPassword = 1;
            num = input.nextInt();
            String userLogin = "";
            double userBalance = 0;

            if (num == 1) {
                String enteredLogin;
                String enteredPassword;
                User found = null;

                do {
                    System.out.println("Enter login: ");
                    System.out.print("> ");
                    enteredLogin = input.next();

                    System.out.println("Enter password: ");
                    System.out.print("> ");
                    enteredPassword = input.next();

                    for (int i = 0; i < users.length; i++) {

                        if (users[i].getLogin().equals(enteredLogin) && users[i].getPass().equals(enteredPassword)) {
                            found = users[i];
                            userLogin = users[i].getLogin();
                            userBalance = users[i].getBalance();
                            break;
                        }
                    }


                    if (found == null) {
                        System.out.println("Incorrect login or password");
                        System.out.println("0) Exit");
                        System.out.println("1) Try again");
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

                    loginOperationResult = true;

                } while (!loginOperationResult);


                if (choiceOfCorrectPassword != 0 && !found.getType().equals(userType)) {
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
                            admin.printTable();

                            for (i = 0; i < users.length; i++) {
                                admin.printUsers(users[i].getLogin(), users[i].getBalance(), users[i].getType(), users[i].isActive());
                            }

                            System.out.format("+============+==========+==========+======+%n");
                            System.out.println("Total users: " + i);

                        }


                        if (choiceOfAdminOperations == 2) {

                            System.out.println("Select the user you would like to change status: ");
                            User.printUsers(users);
                            choice = input.next();

                            for (int i = 0; i < users.length; i++) {

                                users[i].setActive(admin.usersStatus(users[i].isActive(), choice, users[i].getLogin()));

                            }
                        }

                    } while (choiceOfAdminOperations != 0 && choiceOfAdminOperations != 3);
                }


                if (choiceOfCorrectPassword != 0 && found.getType().equals(userType)) {
                    System.out.println("Welcome, " + userLogin + "! Your balance: " + userBalance);


                    int button;


                    do {

                        System.out.println("Choose operation:");
                        System.out.println("0) exit");
                        System.out.println("1) refill");
                        System.out.println("2) withdraw");
                        System.out.print("> ");
                        button = input.nextInt();
                        double cash;


                        if (button == 1) {

                            System.out.println("Enter the amount you want to replenish");
                            cash = input.nextDouble();

                            for (int i = 0; i < users.length; i++) {

                                if (users[i].getLogin().equals(userLogin)) {
                                    users[i].setBalance(bnk.refillCount(cash, users[i].getBalance()));
                                }
                            }
                        }

                        if (button == 2) {

                            System.out.println("Enter the amount to withdraw");
                            cash = input.nextDouble();

                            for (int i = 0; i < users.length; i++) {

                                if (users[i].getLogin().equals(userLogin)) {
                                    users[i].setBalance(bnk.withdrawCount(cash, users[i].getBalance()));
                                }
                            }
                        }
                    } while (button != 0);
                }
            }


            if (num == 2) {

                User user1 = new User();

                do {
                    System.out.print("Enter login: ");
                    login = input.next();
                    regOfUsers.usr(users, login, user1);
                    user1 = regOfUsers.usr(users, login, user1);


                    if (regOfUsers.usr(users, login, user1) == null) {
                        System.out.println("login exists");
                    }


                } while (regOfUsers.usr(users, login, user1) == null);


                do {
                    System.out.print("Enter password: ");
                    password = input.next();

                    System.out.print("Confirm password: ");
                    passwordConfirmation = input.next();

                    if (!passwordConfirmation.equals(password)) {
                        System.out.println("Password doesn't match");
                    }

                } while (!passwordConfirmation.equals(password));


                user1.setPass(password);
                user1.setActive(true);
                user1.setType(userType);
                user1.setBalance(0);


                User[] updatedArray = new User[users.length + 1];

                for (int i = 0; i < users.length; i++) {
                    updatedArray[i] = users[i];
                }

                updatedArray[updatedArray.length - 1] = user1;
                users = updatedArray;
                User.printArray(users);
            }
        } while (num != 0);

        System.out.println("Good bye");
    }
}



