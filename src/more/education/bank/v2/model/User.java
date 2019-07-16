package more.education.bank.v2.model;

public class User {


    private String login;
    private String password;
    private double balance;
    private boolean active;
    private UserType type;

    public User() {
    }

    public User(String login, String password, double balance, boolean active, UserType type) {
        this.login = login;
        this.password = password;
        this.balance = balance;
        this.active = active;
        this.type = type;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", active='" + active + '\'' +
                ", type='" + type + '\'' +
                '}';

    }

    public static void printArray(User[] users) {
        for (int i = 0; i < users.length; i++) {
            System.out.println(users[i]);
        }
    }

    public static void printUsers(User[] users) {
        for (int i = 0; i < users.length; i++) {
            System.out.println(users[i].getLogin());
        }
    }


}






