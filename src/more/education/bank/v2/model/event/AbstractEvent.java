package more.education.bank.v2.model.event;

import java.util.Date;


public abstract class AbstractEvent {

    private String username;

    public AbstractEvent(String username) {
        this.username = username;
    }


    private Date trackeddAt;

    public Date getTrackeddAt() {
        return trackeddAt;
    }

    public void setTrackeddAt(Date trackeddAt) {
        this.trackeddAt = trackeddAt;
    }







   /* @Override
    public String toString() {
        return "AbstractEvent{" +
                "trackeddAt=" + trackeddAt +
                '}' ;
    }*/
}
