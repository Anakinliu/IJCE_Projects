package chapter1.se10;

import java.util.Random;

public class Task implements Runnable{
    @Override
    public void run() {
        int result;
        Random random = new Random(Thread.currentThread().getId());
        while (true) {
            // 制造异常
            // 可能会抛出 java.lang.ArithmeticException: / by zero
            result = 1000 / ((int) (random.nextDouble() * 1000000000));
            if (Thread.currentThread().isInterrupted()) {
                System.out.printf("%d: Interrupted \n",
                        Thread.currentThread().getId());
                return;
            }
        }
    }
}
