package chapter1.se7;

import java.util.Date;
import java.util.Deque;

/*
* 守护线程
* 用于清理队列中超过10s的事件
* */
public class CleanerTask extends Thread{
    private Deque<Event> deque;

    public CleanerTask(Deque<Event> deque) {
        this.deque = deque;
        System.out.println("In CleanerTask Constructor: " + 
                Thread.currentThread().getState());
        /*
        * setDaemon()方法只能在start()方法之前调用，
        * 一旦线程开始执行，其daemon状态便不可修改。
        * */
        setDaemon(true);
    }

    @Override
    public void run() {
        while (true) {
            Date date = new Date();
            clean(date);
        }
    }

    private void clean(Date date) {
        /*
        * 该方法获取队列中的最后一个事件，
        * 如果该事件已创建超过10s，
        * 则从队列中删除该事件并检查下一个事件。
        * 如果删除了一个事件，则输出该事件信息及队列大小，
        * 便于观察执行过程
        * */
        long difference;
        boolean delete;
        if (deque.size() == 0) {
            return;
        }
        delete = false;

        // 遍历 deque ，删除所有超过 10s 的事件
        do {
            Event e = deque.getLast();
            difference = date.getTime() - e.getEventDate().getTime();
            if (difference > 10000) {  // 过10s
                System.out.println("Cleaner: " + e.getEventName());
                deque.removeLast();
                delete = true;
            }
        }while (difference > 10000);
        if (delete) {
            System.out.println("Cleaner: After deleted， size of deque is : " + deque.size() + " isAlive: " + isAlive());
        }
    }
}
