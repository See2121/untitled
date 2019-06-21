package more.education.bank.v2.processor;


import more.education.bank.v2.model.SaveOperations;

public class UsersCredentials extends SaveOperations {


    public UsersCredentials() {

    }


    public UsersCredentials(String login, String password) {
        super(login, password);
    }
}
