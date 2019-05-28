

import java.util.Scanner;

public class UsersReg {

    public static void main(String[] args) {
        final String userStatus = "false";

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
                String checkLogin;
                String checkPassword;
                String userLogin = "";
                String userPassword = "";
                String typeOfAdmin = "admin";
                String typeOfUser = "customer";

                String checkStatusOfUser = "";
                String checkType = "";
                double balance = 0;
                byte choiceOfCorrectPassword = 1;
                do {

                    System.out.println("Enter login: ");
                    System.out.print("> ");
                    checkLogin = input.next();

                    System.out.println("Enter password: ");
                    System.out.print("> ");
                    checkPassword = input.next();

                    for (int i = 0; i < users.length; i++) {
                        String[] str = users[i].split("\\|\\|");


                        if (str[0].equals(checkLogin) && str[1].equals(checkPassword) && !userStatus.equals(str[4])) {
                            userLogin = str[0];
                            userPassword = str[1];
                            checkType = str[3];
                            checkStatusOfUser = str[4];
                            balance = Double.parseDouble(str[2]);
                        }

                    }


                    if (!checkLogin.equals(userLogin) || !checkPassword.equals(userPassword)) {
                        System.out.println("Incorrect login or password \n" +
                                "or user is not active");
                        System.out.println("0) Exit");
                        System.out.println("1) Try again");
                        choiceOfCorrectPassword = input.nextByte();
                        if (choiceOfCorrectPassword == 0) {
                            break;
                        }
                    }


                } while (!checkLogin.equals(userLogin) && !checkPassword.equals(userPassword));


                if (choiceOfCorrectPassword != 0 && typeOfAdmin.equals(checkType)) {
                    byte choiceOfAdminOperations;

                    System.out.println("Welcome admin");

                    do {

                        System.out.println("0) Exit");
                        System.out.println("1) print users");
                        choiceOfAdminOperations = input.nextByte();

                        if (choiceOfAdminOperations == 1) {
                            System.out.println("Users:");
                            for (int i = 0; i < users.length; i++) {
                                String[] str = users[i].split("\\|\\|");
                                System.out.println(str[0] + " " + str[3] + " " + str[4]);
                            }
                        }


                    } while (choiceOfAdminOperations != 0 && choiceOfAdminOperations != 2);
                }


                if (choiceOfCorrectPassword != 0 && typeOfUser.equals(checkType)) {
                    System.out.println("Welcome, " + userLogin + "! Your balance: " + balance);


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
                                    balance += number;

                                    for (int i = 0; i < users.length; i++) {
                                        String[] str = users[i].split("\\|\\|");


                                        if (str[0].equals(userLogin)) {
                                            users[i] = userLogin + "||" + userPassword + "||" + balance + "||" + checkType + "||true";

                                        }

                                    }

                                }

                            } while (number <= 0);

                            System.out.println("Successful operation. Your balance: " + balance);

                        }

                        if (choiceOfBankOperations == 2) {

                            do {
                                System.out.println("Enter the amount to withdraw");
                                System.out.println("0) exit");
                                System.out.print("> ");
                                number = input.nextDouble();


                                if (number < 0 || number > balance) {
                                    System.out.println("You cannot withdraw this amount");
                                    System.out.println("Your balance: " + balance);
                                }
                                if (number == 0) {
                                    System.out.println("You exit");
                                } else {
                                    balance = balance - number;

                                    for (int i = 0; i < users.length; i++) {
                                        String[] str = users[i].split("\\|\\|");


                                        if (str[0].equals(userLogin)) {
                                            users[i] = userLogin + "||" + userPassword + "||" + balance + "||" + checkType + "||true";
                                        }

                                    }

                                }


                            } while (number > balance || number < 0 && number == 0);


                            System.out.println("Your balance " + balance);


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
                }
                while (next != 0);


            }
        }
        while (num != 0);
        System.out.println("Good bye");


    }
}
