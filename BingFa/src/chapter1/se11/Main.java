package chapter1.se11;

import java.util.concurrent.ThreadFactory;

public class Main {
    public static void main(String[] args) {
        Task task = new Task();
        MyThreadFactory factory = new MyThreadFactory("我的线程");
        Thread t;
        for (int i = 0; i < 10; i++) {
            t = factory.newThread(task);
            t.start();
        }
        System.out.println("Factory stats:");
        System.out.println(factory.getStats());

        // 看着和 java 自带的线程工厂没啥区别啊
//        Task task = new Task();
//        RenXingThreadFactory factory = new RenXingThreadFactory("我的线程");
//        Thread t;
//        for (int i = 0; i < 10; i++) {
//            t = factory.newThread(task);
//            t.start();
//        }
//        System.out.println("Factory stats:");
//        System.out.println(factory.getStats());
    }


}
