package more.education.bank.v2.service;

import more.education.bank.v2.api.service.MonitoringService;
import more.education.bank.v2.model.event.AbstractEvent;

import java.io.Serializable;


public class InMemoryMonitoringServiceImpl implements MonitoringService, Serializable {

    private AbstractEvent[] events = new AbstractEvent[]{};


    public void logEvent(AbstractEvent event) {

        AbstractEvent[] updatedArray = new AbstractEvent[events.length + 1];
        for (int i = 0; i < events.length; i++) {
            updatedArray[i] = events[i];
        }

        updatedArray[updatedArray.length - 1] = event;
        events = updatedArray;
    }


    public AbstractEvent[] getEvents() {

        for (int i = 0; i < events.length; i++) {
            System.out.println(events[i]);
        }

        return events;

    }


}
