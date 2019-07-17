package more.education.bank.v1;

import java.util.Scanner;

public class UsersReg {
    private static final String USER_STATUS_DISABLED = "false";
    private static final String TYPE_OF_ADMIN = "admin";
    private static final String TYPE_OF_USER = "customer";


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] users = new String[]{
                "admin||admin||0||admin||true"
        };
        final int size = 1;
        int num;

        do {
            String login, password;

            System.out.println("Select an action:");
            System.out.println("1) user authorization");
            System.out.println("2) user registration");
            System.out.println("0) exit");
            System.out.print("> ");

            num = input.nextInt();

            if (num == 1) {
                String enteredLogin;
                String enteredPassword;

                String userLogin = null;
                String userPassword = null;
                String userType = null;
                String userStatus = null;
                double userBalance = 0;

                byte choiceOfCorrectPassword = 1;

                boolean loginOperationResult = false;
                do {

                    System.out.println("Enter login: ");
                    System.out.print("> ");
                    enteredLogin = input.next();

                    System.out.println("Enter password: ");
                    System.out.print("> ");
                    enteredPassword = input.next();


                    for (int i = 0; i < users.length; i++) {
                        String[] str = users[i].split("\\|\\|");

                        if (str[0].equals(enteredLogin) && str[1].equals(enteredPassword)) {
                            userLogin = str[0];
                            userPassword = str[1];
                            userBalance = Double.parseDouble(str[2]);
                            userType = str[3];
                            userStatus = str[4];
                        }
                    }

                    if (userLogin == null) {
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

                    if (USER_STATUS_DISABLED.equals(userStatus)) {
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


                if (choiceOfCorrectPassword != 0 && TYPE_OF_ADMIN.equals(userType)) {
                    byte choiceOfAdminOperations;

                    System.out.println("Welcome admin");

                    do {

                        System.out.println("0) Exit");
                        System.out.println("1) print users");
                        System.out.println("2) correct status of user");
                        System.out.print("> ");
                        choiceOfAdminOperations = input.nextByte();
                        int x;
                        String choice;

                        if (choiceOfAdminOperations == 1) {
                            System.out.println("Users:");
                            System.out.format("+============+==========+==========+======+%n");
                            System.out.format("| Username   | Balance  | Type     |Status|%n");
                            System.out.format("+============+==========+==========+======+%n");

                            for (x = 0; x < users.length; x++) {
                                String[] str = users[x].split("\\|\\|");

                                System.out.format("|%-12s|%-10s|%-10s|%-6s|%n", str[0], str[2], str[3], str[4]);

                            }
                            System.out.format("+============+==========+==========+======+%n");
                            System.out.println("Total users: " + x);

                        }


                        if (choiceOfAdminOperations == 2) {
                            System.out.println("Select the user you would like to change status: ");
                            for (x = 0; x < users.length; x++) {
                                String[] str = users[x].split("\\|\\|");
                                System.out.println(str[0]);
                            }

                            choice = input.next();

                            for (x = 0; x < users.length; x++) {
                                String[] str = users[x].split("\\|\\|");

                                if (str[0].equals(choice)) {

                                    if (str[4].equals("false")) {
                                        users[x] = choice + "||" + str[1] + "||" + str[2] + "||" + str[3] + "||true";
                                    } else {
                                        users[x] = choice + "||" + str[1] + "||" + str[2] + "||" + str[3] + "||false";
                                    }

                                }

                            }

                        }


                    } while (choiceOfAdminOperations != 0 && choiceOfAdminOperations != 3);
                }


                if (choiceOfCorrectPassword != 0 && TYPE_OF_USER.equals(userType)) {
                    System.out.println("Welcome, " + userLogin + "! Your balance: " + userBalance);


                    int choiceOfBankOperations;
                    do {
                        System.out.println("Choose operation:");
                        System.out.println("0) exit");
                        System.out.println("1) refill");
                        System.out.println("2) withdraw");
                        System.out.print("> ");

                        choiceOfBankOperations = input.nextInt();

                        if (choiceOfBankOperations != 1 && choiceOfBankOperations != 2 && choiceOfBankOperations != 0) {
                            System.out.println("Wrong option");
                            continue;
                        }

                        double number;
                        if (choiceOfBankOperations == 1) {

                            do {

                                System.out.println("Enter the amount you want to replenish");
                                System.out.println("0) exit");
                                System.out.print("> ");
                                number = input.nextDouble();

                                if (number < 0) {
                                    System.out.println("The amount must be positive");
                                    if (number == 0) {
                                        System.out.println("You exit");
                                        break;
                                    }

                                } else {
                                    userBalance += number;

                                    for (int i = 0; i < users.length; i++) {
                                        String[] str = users[i].split("\\|\\|");


                                        if (str[0].equals(userLogin)) {
                                            users[i] = userLogin + "||" + userPassword + "||" + userBalance + "||" + userType + "||true";

                                        }

                                    }

                                }

                            } while (number <= 0);

                            System.out.println("Successful operation. Your balance: " + userBalance);

                        }

                        if (choiceOfBankOperations == 2) {

                            do {
                                System.out.println("Enter the amount to withdraw");
                                System.out.println("0) exit");
                                System.out.print("> ");
                                number = input.nextDouble();


                                if (number < 0 || number > userBalance) {
                                    System.out.println("You cannot withdraw this amount");
                                    System.out.println("Your balance: " + userBalance);
                                }
                                if (number == 0) {
                                    System.out.println("You exit");
                                } else {
                                    userBalance = userBalance - number;

                                    for (int i = 0; i < users.length; i++) {
                                        String[] str = users[i].split("\\|\\|");


                                        if (str[0].equals(userLogin)) {
                                            users[i] = userLogin + "||" + userPassword + "||" + userBalance + "||" + userType + "||true";
                                        }

                                    }

                                }


                            } while (number > userBalance || number < 0 && number == 0);


                            System.out.println("Your balance: " + userBalance);

                        }


                    } while (choiceOfBankOperations != 0);
                }

            }

            if (num == 2) {

                String passwordConfirmation;
                boolean duplicateFound = false;


                byte next;
                do {
                    System.out.println("1) register of user");
                    System.out.println("0) exit");
                    next = input.nextByte();
                    if (next == 1) {
                        do {
                            System.out.print("Enter login: ");
                            login = input.next();

                            for (int i = 0; i < users.length; i++) {
                                String[] str = users[i].split("\\|\\|");
                                duplicateFound = str[0].equals(login);
                                if (duplicateFound) {
                                    break;
                                }
                            }
                        }
                        while (duplicateFound);

                        do {
                            System.out.print("Enter password: ");
                            password = input.next();

                            System.out.print("Confirm password: ");
                            passwordConfirmation = input.next();

                            if (!passwordConfirmation.equals(password)) {
                                System.out.println("Password doesn't match");
                            }

                        } while (!passwordConfirmation.equals(password));


                        String[] updatedArray = new String[users.length + size];
                        for (int i = 0; i < users.length; i++) {
                            updatedArray[i] = users[i];
                        }

                        updatedArray[updatedArray.length - 1] = login + "||" + password + "||0||customer||false";


                        users = updatedArray;
                        System.out.println("Users:");
                        for (int i = 0; i < users.length; i++) {
                            System.out.println("- " + users[i]);
                        }

                    }
                } while (next != 0);


            }
        } while (num != 0);

        System.out.println("Good bye");
    }
}
