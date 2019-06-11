package more.education.bank.v2;

public class RegOfUsers {

    public User usr(User[] users, String login, User user1){
        int i;

        for (i = 0; i < users.length; i++) {
            user1 = new User();
            if (users[i].getLogin().equals(login)) {
                return null;
            } else {

                user1.setLogin(login);
            }
        }

        return user1;
    }


}
