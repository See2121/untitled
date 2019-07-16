package more.education.bank.v2.model.event;

import java.util.Date;

public class UserSuccessLoginEvent extends AbstractEvent {
    private Date trackeddAt;
    private String successLogin;

    public UserSuccessLoginEvent(String successLogin, Date trackeddAt){
        super(successLogin);
        this.successLogin=successLogin;
        this.trackeddAt=trackeddAt;
    }

    public String getSuccessLogin(){
        return successLogin;
    }




    @Override
    public String toString() {
        return "Successful Login: " + successLogin + "  Time:  " + trackeddAt ;

    }

}
