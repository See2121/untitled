package more.education.bank.v2.model;


public abstract class SaveOperations {

    private String login;
    private String password;


    public SaveOperations(){

    }


    public SaveOperations(String login,String password) {
        this.login = login;
        this.password=password;
    }



    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }


    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }



    @Override
   public String toString() {
        return "login: " + login + " Password: " + password;

    }
}
