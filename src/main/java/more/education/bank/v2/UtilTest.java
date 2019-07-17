package more.education.bank.v2;

import more.education.bank.v2.model.User;
import more.education.bank.v2.model.UserType;

class UtilTest {

    public static void main(String[] args) {
        // should find nothing because users list is null
        assert (Util.searchUser(null, "test") == null) : "User should be null";
        // should find nothing because user with username test doesn't exist
        assert (Util.searchUser(new User[]{}, "test") == null) : "User should be null";

        assert (Util.searchUser(new User[]{new User("1", "1", 0.0, true, UserType.CUSTOMER)}, "test") == null) : "User should be null";
       // assert (Util.searchUser(new User[]{new User("1", "1", 0.0, true, UserType.CUSTOMER)}, "1") != null) : "User should exists";
        User found = Util.searchUser(new User[]{
                new User("1", "1", 0.0, true, UserType.CUSTOMER),
                new User("2", "2", 0.0, true, UserType.CUSTOMER)
        }, "1");
        assert (found != null) : "User should exists";
        assert (found.getLogin().equals("1")) : "User should exists";




        /*

        User[] users = new User[1];
        for (int i = 0; i < 1; i++) {
            users[i] = new User(String.valueOf(i), String.valueOf(i), 0.0, true, UserType.CUSTOMER);
        }

        Date started = new Date();
        found = Util.searchUser(users, "1");
        assert (found != null) : "User should exists";
        assert (found.getLogin().equals("1")) : "User should exists";
        Date finished = new Date();
        long diff = finished.getTime() - started.getTime();
        System.out.println(diff);
        long timeSpent = diff / 1000;
        System.out.println(timeSpent);
        assert (diff < 100) : "Search algorithm is not efficient";

         */
    }
}

