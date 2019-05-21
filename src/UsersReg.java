
import java.util.Scanner;

public class UsersReg {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] users = new String[]{};
        int num;
        final int size = 1;

        do {
            String login, password, passwordConfirmation, checkLogin, checkPassword;
            System.out.println("Select an action:");
            System.out.println("1) authorization");
            System.out.println("2) register");
            System.out.println("0) exit");
            System.out.print("> ");

            num = input.nextInt();


            if (num == 1) {
                String log = "";
                String pass = "";
                String o = "0";
                do {

                    System.out.println("Enter login: ");
                    System.out.print("> ");
                    checkLogin = input.next();

                    System.out.println("Enter password: ");
                    System.out.print("> ");
                    checkPassword = input.next();

                    // login password check
                    for (int i = 0; i < users.length; i++) {
                        String[] str = users[i].split("\\|\\|");

                        if (str[0].equals(checkLogin) && str[1].equals(checkPassword)) {
                            log = str[0];
                            pass = str[1];
                            break;
                        }
                    }

                    if (!checkLogin.equals(log) || !checkPassword.equals(pass)) {
                        System.out.println("Incorrect login or password");
                        System.out.println("0) Exit");
                        System.out.println("1) Try again");
                        int r = input.nextInt();
                        if (r == 0) {
                            break;
                        }
                    }

                } while (!checkLogin.equals(log) && !checkPassword.equals(pass));

                System.out.println("Welcome, " + log);

            }

            if (num == 2) {

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

                updatedArray[updatedArray.length - 1] = login + "||" + password;
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
