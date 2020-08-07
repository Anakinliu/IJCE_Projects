package chapter1.se9;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class UnsafeTask implements Runnable{

    private Date startDate;

    @Override
    public void run() {
        // 每个线程都持有一个 Date 对象，但是当线程有了多个存在，会串
        startDate = new Date();
        System.out.println("Starting Thread: " +
                Thread.currentThread().getId() + " : " +
                startDate.toString());
        try {
            TimeUnit.SECONDS.sleep(5 + (int) Math.rint((Math.random() * 10)));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread Finished " +
                Thread.currentThread().getId() + " : " +
                startDate.toString());
    }
}
