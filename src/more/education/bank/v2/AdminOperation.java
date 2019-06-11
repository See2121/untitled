package more.education.bank.v2;

public class AdminOperation {

    void printTable() {
        System.out.println("Users:");
        System.out.format("+============+==========+==========+======+%n");
        System.out.format("| Username   | Balance  | Type     |Status|%n");
        System.out.format("+============+==========+==========+======+%n");
    }


    public void printUsers(String login, double balance, UserType type, boolean status) {

        System.out.format("|%-12s|%-10s|%-10s|%-6s|%n", login, balance, type, status);


    }


    boolean usersStatus (boolean status, String choice, String login) {
       if (choice.equals(login)) {
            if (status==true) {
                status =false;
           } else {
                status = true;
            }
        }


        return status;


    }
}
