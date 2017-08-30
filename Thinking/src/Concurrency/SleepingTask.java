package Concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Anakinliu on 2017/8/1.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
class SecondTask implements Runnable{
    int secondToSleep ;

    public SecondTask(int secondToSleep) {
        this.secondToSleep = secondToSleep;
    }

    @Override
    public void run() {
        System.out.println("I' will sleep " + secondToSleep + "s.");
        try {
            TimeUnit.SECONDS.sleep(secondToSleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("After " + secondToSleep + "s, I am END.");
        }
    }
}
public class SleepingTask implements Runnable {
    int countDonw = 10;
    @Override
    public void run() {
        while (countDonw > 0) {
            System.out.println(countDonw);
            countDonw --;
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) { e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Random random = new Random();

        for (int i = 5; i > 0; i--) {
//            executorService.execute(new SleepingTask());

            int secondToSleep = random.nextInt(10);
            executorService.execute(new SecondTask(secondToSleep));
        }
        executorService.shutdown();
    }
}
