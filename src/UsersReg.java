
import java.util.Scanner;

public class UsersReg {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] users = new String[]{};
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
                double balance = 0;
                byte r =1;

                do {

                    System.out.println("Enter login: ");
                    System.out.print("> ");
                    checkLogin = input.next();

                    System.out.println("Enter password: ");
                    System.out.print("> ");
                    checkPassword = input.next();

                    for (int i = 0; i < users.length; i++) {
                        String[] str = users[i].split("\\|\\|");


                        if (str[0].equals(checkLogin) && str[1].equals(checkPassword)) {
                            userLogin = str[0];
                            userPassword = str[1];
                            balance = Double.parseDouble(str[2]);


                        }

                    }

                    if (!checkLogin.equals(userLogin) || !checkPassword.equals(userPassword)) {
                        System.out.println("Incorrect login or password");
                        System.out.println("0) Exit");
                        System.out.println("1) Try again");
                        r = input.nextByte();
                        if (r==0){
                            break;
                        }

                    }
                } while (!checkLogin.equals(userLogin) && !checkPassword.equals(userPassword));

                if (r != 0) {
                    System.out.println("Welcome, " + userLogin + "! Your balance: " + balance);


                    int choiceOfOperations;
                    do {
                        System.out.println("Choose operation:");
                        System.out.println("0) exit");
                        System.out.println("1) refill");
                        System.out.println("2) withdraw");
                        System.out.print("> ");

                        choiceOfOperations = input.nextInt();

                        if (choiceOfOperations != 1 && choiceOfOperations != 2 && choiceOfOperations != 0) {
                            System.out.println("Wrong option");
                            continue;
                        }

                        double number;
                        if (choiceOfOperations == 1) {

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
                                            users[i] = userLogin + "||" + userPassword + "||" + balance;
                                        }

                                    }

                                }

                            } while (number <= 0);

                            System.out.println("Successful operation. Your balance: " + balance);

                        }

                        if (choiceOfOperations == 2) {

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
                                            users[i] = userLogin + "||" + userPassword + "||" + balance;
                                        }

                                    }

                                }


                            } while (number > balance || number < 0 && number == 0);


                            System.out.println("Your balance " + balance);


                        }


                    } while (choiceOfOperations != 0);
                }


            }

            if (num == 2) {
                String passwordConfirmation;
                boolean duplicateFound = false;

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
                } while (duplicateFound);


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

                updatedArray[updatedArray.length - 1] = login + "||" + password + "||" + 0;
                users = updatedArray;
                System.out.println("Users:");
                for (int i = 0; i < users.length; i++) {
                    System.out.println("- " + users[i]);
                }


            }
        }
        while (num != 0);
        System.out.println("Good bye");


    }
}
