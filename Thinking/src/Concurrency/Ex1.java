package Concurrency;

/**
 * Created by Anakinliu on 2017/7/28.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
class Thread1 implements Runnable {

    long time = 0;

    public Thread1() {
        time = System.currentTimeMillis();
        System.out.println("Constructing thread!");
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.println("Times " + i +" ; " + (System.currentTimeMillis() - time) );
            Thread.yield();
        }
        System.out.println("Thread1 run() completed!");

    }
}
public class Ex1 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new Thread1()).start();
        }
    }
}
