package cz.datalite.micronaut;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller("/hello")
public class HelloController {
    Counter c = new Counter();

    @Get("/")
    @Produces(MediaType.TEXT_HTML)
    public String index() {
        String hostname = "";
        String ip = "";
        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getLocalHost();
            ip = inetAddress.getHostAddress();
            hostname = inetAddress.getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy HH:mm:ss");
        String formattedDate = dateFormat.format(date);
        c.add(1);
        return "<html><body><h1>Hello from '" + hostname + "' (cnt: '" + c.get() + "', ip: '" + ip + "', dateTime: '" + formattedDate + "')</h1></body></html>";
    }
}
