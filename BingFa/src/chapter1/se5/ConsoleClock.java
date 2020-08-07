package chapter1.se5;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ConsoleClock implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s %s\n", new Date(), Thread.currentThread().getState());
            try {
                /*
                * 当调用sleep()方法时，线程释放CPU资源，
                * 停止执行指定的时间。在这段时间里，线程并不消耗CPU时间
                * */
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                System.out.println("The Clock has been interrupted.");
            }
        }
    }
}
