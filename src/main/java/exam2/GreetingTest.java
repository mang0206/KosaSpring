package exam2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;

public class GreetingTest {
    public static void main(String[] args) {
        ApplicationContext factory
                = new ClassPathXmlApplicationContext("exam2.xml");

        LocalDateTime ldt = factory.getBean("localdate", LocalDateTime.class);
        Greeting greeting = null;

        int hour = ldt.now().getHour();
        if(hour >= 6 & hour <12){
            greeting = factory.getBean("morning", MorningGreetingImpl.class);
        } else if( hour >= 12 & hour < 17) {
            greeting = factory.getBean("afternoon", AfternoonGreetingImp.class);
        } else if (hour >= 17 & hour < 22) {
            greeting = factory.getBean("evening", EveningGreetingImpl.class);
        } else {
            greeting = factory.getBean("night", NightGreetingImpl.class);
        }

        greeting.greet();
        ((ClassPathXmlApplicationContext)factory).close();
    }
}
