package chapter1.se7;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        Deque<Event> deque = new ConcurrentLinkedDeque<>();
        Deque<Event> deque = new ConcurrentLinkedDeque<>();
        WriterTask writerTask = new WriterTask(deque);
        // 12
//        System.out.println(Runtime.getRuntime().availableProcessors());
        // 开启 12 个用户线程，向同一个队列写入事件
        for (int i = 0; i < Runtime.getRuntime().availableProcessors();i++) {
            Thread thread = new Thread(writerTask);
            thread.start();
        }

        // 开启守护线程---清除队列中10s前添加的事件
        CleanerTask cleanerTask = new CleanerTask(deque);
        cleanerTask.start();
        System.out.println("All Thread is Over.");
    }
}
