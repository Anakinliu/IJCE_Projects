package InnerClass;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anakinliu on 2017/2/23.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
abstract class Event {
    private long eventTime;

    protected final long delayTime ;

    public Event (long delayTime) {
        this.delayTime = delayTime;
        start();
    }

    // out of the constructor, so allows restarting
    public void start () {
        eventTime = System.nanoTime() + delayTime;
    }

    public boolean ready () {
        return System.nanoTime() >= eventTime;
    }

    //不同的Event子类由不同的实现
    public abstract void action () ;
}
public class Controller {
    private List<Event> eventList = new ArrayList<>();

    public void addEvent(Event c) {
        eventList.add(c);

    }

    public void run() {
        while (eventList.size() > 0) {
            // make a copy so you're not modifying the list while
            // you're selecting the elements in it:
            for(Event e : new ArrayList<>(eventList)) {
                if (e.ready()) {
                    System.out.println(e);
                    e.action();
                    eventList.remove(e);
                }
            }
        }
    } 

//    public static void main(String[] args) {
//        Controller controller =  new Controller();
//        //使用long,需要加L!!!!
//        // 话说用这个控制时间很好使啊!
//        controller.addEvent(new Event(1000000000L) {
//            @Override
//            public void action() {
//                System.out.println("I'm ready! Doing action!");
//            }
//        });
//        controller.run();
//    }

}
