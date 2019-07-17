package more.education.bank.v2.service;

import more.education.bank.v2.api.service.MonitoringService;
import more.education.bank.v2.model.event.AbstractEvent;

import java.io.*;

public class FileBasedMonitoringService implements MonitoringService {


    @Override
    public void logEvent(AbstractEvent event) {

        File file = new File("SaveEvents.txt");
        try {

            String s;

            s = String.valueOf(event.toString());

            FileWriter writer = new FileWriter(file, true);

            writer.write(s);
            writer.close();


        } catch (Exception e) {

        } finally {

        }
    }


    @Override
    public AbstractEvent[] getEvents() {
        BufferedReader br;

        try {


            br = new BufferedReader(new InputStreamReader(new FileInputStream("SaveEvents.txt"), "UTF8"));
            StringBuilder sb = new StringBuilder(String.valueOf(br));
            String s;
            while ((s = br.readLine()) != null) {
                sb.append(s).append('\n');
            }
            s = sb.toString();

            System.out.println(s);

            br.close();


        } catch (IOException ex) {
            ex.printStackTrace();
        }


        return new AbstractEvent[0];

    }
}
