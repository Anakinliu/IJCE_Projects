package chapter1.se5;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ConsoleClock clock = new ConsoleClock();
        Thread thread = new Thread(clock);
        thread.start();


        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*
         * 当线程在休眠中发生中断时，
         * 该方法会立即抛出一个InterruptedException异常，
         * 而不会等到休眠时间结束。
         * 结果不会等待 5 秒，而是提前打印，
         * 此时，中断线程相当于循环中的一个continue
         * */
        thread.interrupt();
    }
}
