package more.education.bank.v2.processor;

import more.education.bank.v2.api.service.MonitoringService;
import more.education.bank.v2.model.event.AbstractEvent;
import more.education.bank.v2.model.event.UserRegisteredEvent;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class AdminOperationProcessorTest {

    /*@Mock
    MonitoringService monitoringService;*/

    @Test
    public void shouldReturnArrayOfEvents() {

        AbstractEvent abstractEvent = new UserRegisteredEvent("test", new Date());
        AbstractEvent[] testEvents = new AbstractEvent[]{abstractEvent};

        MonitoringService monitoringService = mock(MonitoringService.class);
        doReturn(testEvents).when(monitoringService).getEvents();

        AbstractEvent[] events = monitoringService.getEvents();

        //  AdminOperationProcessor adminOperationProcessor = mock(AdminOperationProcessor.class);

        //  doNothing().when(adminOperationProcessor).processor(any(), any(), any());

        //  adminOperationProcessor.processor(any(), any(), any());


      //  verify(monitoringService, times(1)).getEvents();

        Assert.assertNotNull(events);
        Assert.assertNotNull(events.length);
        Assert.assertEquals(1, events.length);
    }

    @Test
    public void printTable() {
    }

    @Test
    public void printUsers() {
    }

    @Test
    public void usersStatus() {

    }
}