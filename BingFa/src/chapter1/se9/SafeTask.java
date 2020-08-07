package chapter1.se9;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SafeTask implements Runnable{

    // 线程本地 变量
    private static ThreadLocal<Date> startDate =
            new ThreadLocal<Date>() {
        /*
        可以用get()和set()方法来分别读写该属性值。

        * 若与该线程对象关联的属性值不存在，
        * 则将会触发initialValue()方法，
        * 它会为该属性赋值并返回初始值。
        * */
                @Override
                protected Date initialValue() {
                    return new Date();
                }
            };

    @Override
    public void run() {
        // 注意访问属性的方式
        System.out.printf("Starting Thread: %s : %s\n",
                Thread.currentThread().getId(), startDate.get());
        try {
            TimeUnit.SECONDS.sleep(5 + (int) (Math.random()) * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Thread Finished: %s : %s\n",
                Thread.currentThread().getId(), startDate.get());
    }
}
