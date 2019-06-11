package javaEducationBank.v2;

public class User {

    private String login;
    private String pass;
    private double balance;
    private boolean active;
    private UserType type;

    public User() {
    }

    public User(String login, String pass, double balance, boolean active, UserType type) {
        this.login = login;
        this.pass = pass;
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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
                ", pass='" + pass + '\'' +
                ", balance=" + balance +
                ", active='" + active + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    static void printArray(User[] users) {
        for (int i = 0; i < users.length; i++) {
            System.out.println(users[i]);
        }
    }

    static void printUsers(User[] users) {
        for (int i = 0; i < users.length; i++) {
            System.out.println(users[i].getLogin());
        }
    }


}





