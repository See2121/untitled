package more.education.bank.v2.api.service;

import more.education.bank.v2.model.event.AbstractEvent;

public interface MonitoringService {


    void logEvent(AbstractEvent event);

    AbstractEvent[] getEvents();

}
