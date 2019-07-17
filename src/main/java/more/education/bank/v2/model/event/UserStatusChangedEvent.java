package more.education.bank.v2.model.event;

import java.util.Date;

public class UserStatusChangedEvent extends AbstractEvent {
    private boolean statusChange;
    private Date trackeddAt;
    private String statusCorrectLogin;

    public UserStatusChangedEvent(String statusCorrectLogin, Date trackeddAt, boolean statusChange) {
        this.trackeddAt = trackeddAt;
        this.statusCorrectLogin = statusCorrectLogin;
        this.statusChange = statusChange;
    }

    @Override
    public String toString() {
        return "Login of User:     " + statusCorrectLogin + "       Time:  " + trackeddAt + "  Incorrect status:  " + statusChange + "\n";

    }

}
