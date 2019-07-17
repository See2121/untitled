package more.education.bank.v2.model.event;
import java.util.Date;


public class UserRegisteredEvent extends AbstractEvent {
    private String userRegisteredName;

    private Date trackeddAt;


    public UserRegisteredEvent(String userRegisteredName, Date trackeddAt) {
        super(userRegisteredName);
        this.userRegisteredName = userRegisteredName;
        this.trackeddAt = trackeddAt;
    }


    @Override
    public String toString() {
        return "Registered Login:     " + userRegisteredName  + "       Time:  " + trackeddAt + "\n";

    }


}
