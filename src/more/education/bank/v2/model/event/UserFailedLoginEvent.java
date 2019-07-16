package more.education.bank.v2.model.event;

import java.util.Date;

public class UserFailedLoginEvent extends AbstractEvent {
    private String failedUsername;

    private Date trackeddAt;


    public UserFailedLoginEvent(String failedUsername, Date trackeddAt) {
        super(failedUsername);

        this.trackeddAt=trackeddAt;
        this.failedUsername = failedUsername;

    }



    @Override
    public String toString() {
        return  "Failed Login: " + failedUsername + "   Time:  " + trackeddAt ;

    }
}
