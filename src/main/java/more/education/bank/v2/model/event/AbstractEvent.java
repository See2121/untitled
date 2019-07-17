package more.education.bank.v2.model.event;

import java.io.Serializable;
import java.util.Date;


public abstract class AbstractEvent implements Serializable {

    private String username;
    private Date trackeddAt;

    public AbstractEvent(String username) {
        this.username = username;
    }

    public AbstractEvent() {

    }


    @Override
    public String toString() {
        return "AbstractEvent{" +
                "username='" + username + '\'' +
                ", trackeddAt=" + trackeddAt +
                '}';
    }
}
