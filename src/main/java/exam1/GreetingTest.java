package exam1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

public class GreetingTest {
    public static void main(String[] args) {
        ApplicationContext factory
                = new ClassPathXmlApplicationContext("exam1.xml");

        LocalDateTime ldt = factory.getBean("localdate", LocalDateTime.class);
        MorningGreetingImpl morning= factory.getBean("morning", MorningGreetingImpl.class);
        AfternoonGreetingImp afternoon= factory.getBean("afternoon", AfternoonGreetingImp.class);
        EveningGreetingImpl evening= factory.getBean("evening", EveningGreetingImpl.class);
        NightGreetingImpl night= factory.getBean("night", NightGreetingImpl.class);

        int hour = ldt.now().getHour();
        if(hour >= 6 & hour <12){
            morning.greet();
        } else if( hour >= 12 & hour < 17) {
            afternoon.greet();
        } else if (hour >= 17 & hour < 22) {
            evening.greet();
        } else {
            night.greet();
        }

        ((ClassPathXmlApplicationContext)factory).close();
    }
}
