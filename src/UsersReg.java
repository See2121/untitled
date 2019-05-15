import java.util.Scanner;

public class UsersReg {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] users = new String[]{};
        byte num;
        final int size = 1;

        do {
            String login, password, passwordConfirmation;

            System.out.println("Select an action:");
            System.out.println("1) authorization");
            System.out.println("2) register");
            System.out.println("0) exit");
            System.out.print("> ");

            num = input.nextByte();

            if (num == 1) {
                System.out.println("This work is in progress");
            }

            if (num == 2) {

                // todo
                System.out.print("Enter login: ");
                login = input.next();


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
        } while (num != 0);

        System.out.println("Good bye");
    }
}
