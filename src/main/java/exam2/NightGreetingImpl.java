package exam2;

import org.springframework.stereotype.Component;

@Component("night")
public class NightGreetingImpl implements Greeting {
    public void greet(){
        System.out.println("안녕히 주무세요.");
    }
}
