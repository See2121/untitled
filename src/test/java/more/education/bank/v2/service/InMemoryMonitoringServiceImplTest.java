package more.education.bank.v2.service;

import more.education.bank.v2.model.event.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class InMemoryMonitoringServiceImplTest {


    @Test
    public void shouldLogUserRegisteredEvent() {
        InMemoryMonitoringServiceImpl inMemoryMonitoringService = new InMemoryMonitoringServiceImpl();

        AbstractEvent event = new UserRegisteredEvent("RegisteredName", new Date());

        inMemoryMonitoringService.logEvent(event);

        Assert.assertNotNull(inMemoryMonitoringService.getEvents());
        Assert.assertEquals(1, inMemoryMonitoringService.getEvents().length);
    }


    @Test
    public void shouldLogUserFailedLoginEvent() {
        InMemoryMonitoringServiceImpl inMemoryMonitoringService = new InMemoryMonitoringServiceImpl();

        AbstractEvent event = new UserFailedLoginEvent("FailedName", new Date());
        inMemoryMonitoringService.logEvent(event);

        Assert.assertNotNull(inMemoryMonitoringService.getEvents());
        Assert.assertEquals(1, inMemoryMonitoringService.getEvents().length);
    }

    @Test
    public void shouldLogUserStatusChangedEvent() {
        InMemoryMonitoringServiceImpl inMemoryMonitoringService = new InMemoryMonitoringServiceImpl();

        AbstractEvent event = new UserStatusChangedEvent("UserName", new Date(), true);
        AbstractEvent[] events = new AbstractEvent[]{event};

        inMemoryMonitoringService.logEvent(event);

        Assert.assertNotNull(inMemoryMonitoringService.getEvents());
        Assert.assertArrayEquals(events, inMemoryMonitoringService.getEvents());
    }

    @Test
    public void shouldLogUserSuccessLoginEvent() {
        InMemoryMonitoringServiceImpl inMemoryMonitoringService = new InMemoryMonitoringServiceImpl();

        AbstractEvent event = new UserSuccessLoginEvent("SuccessLogin", new Date());
        inMemoryMonitoringService.logEvent(event);

        Assert.assertNotNull(inMemoryMonitoringService.getEvents());
        assertEquals(1, inMemoryMonitoringService.getEvents().length);
    }


}