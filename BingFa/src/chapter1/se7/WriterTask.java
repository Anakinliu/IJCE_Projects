package chapter1.se7;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

/*
* 用户线程
* 用于向队列写入事件
* */
public class WriterTask implements Runnable {

    // 用于存储事件的队列
    private Deque<Event> deque;

    public WriterTask(Deque<Event> deque) {
        this.deque = deque;
    }

    @Override
    public void run() {

        //在每一次迭代中，我们创建
        // 一个新的事件并将其存储到队列当中，然后休眠1s
        // 线程 1 s 添加 1 个时间
        for (int i = 0; i < 30; i++) {
            Event event = new Event();
            event.setEventDate(new Date());
            event.setEventName(String.format("The " +
                            "Thread" +
                            "%s" +
                            "has" +
                            "generated" +
                            "an" +
                            "event",
                    Thread.currentThread().getId()));
            deque.addFirst(event);  // 放到队列中
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
