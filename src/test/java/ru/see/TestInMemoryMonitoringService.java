package ru.see;

import more.education.bank.v2.model.event.AbstractEvent;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class TestInMemoryMonitoringService {


    @Test(timeout = 100)
  public   void testInMemoryMS () throws IOException {

/*

        InMemoryMonitoringServiceImpl inMemoryMonitoringService = new InMemoryMonitoringServiceImpl();
        Assert.assertNotNull(inMemoryMonitoringService);
        AbstractEvent abstractEvent = new UserRegisteredEvent("name",new Date());
        inMemoryMonitoringService.logEvent(abstractEvent);
        Assert.assertNotNull(inMemoryMonitoringService.getEvents());
*/


    }

    @Test
    private AbstractEvent[] testAbstrctEvents() {
        return testAbstrctEvents();
    }

    @Test
    private AbstractEvent[] testAbstrctEvents(AbstractEvent event){

        Assert.assertNotNull(event);





        return new AbstractEvent[0];
    }
}
