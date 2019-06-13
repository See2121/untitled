package more.education.bank.v2;

public class Util {

    public static User searchUser(User[] users, String username) {
        User found = null;

        if (users == null) return null;

        for (int i = 0; i < users.length; i++) {
            if (username.equals(users[i].getLogin())) {
                found = users[i];
                break;
            }
        }

        return found;
    }


}
