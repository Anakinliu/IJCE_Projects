package chapter1.se10;

import chapter1.se8.ExceptionHandler;

public class Main {
    public static void main(String[] args) {
        /*
        * 计算将要启动的线程数。
        * 使用Runtime类的availableProcessors()方法
        * ［使用Runtime类的静态方法getRuntime()得到当前应用的Runtime对象］，
        * 可以得到JVM中可用的处理器数，它通常与运行该应用的计算机内核数一致
        * */
        int numberOfThreads = 2 * Runtime.getRuntime().availableProcessors();

//        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());

        MyThreadGroup threadGroup = new MyThreadGroup("我的线程组");
        Task task = new Task();

        // 创建之前计算得出的数量的Thread对象，执行task并启动
        for (int i = 0; i < numberOfThreads; i++) {
            // 这些线程都在一个 组 里
            Thread t = new Thread(threadGroup, task);
            t.start();
        }

        // 输出ThreadGroup的信息
        System.out.printf("Number of Threads: %d\n", threadGroup.activeCount());
        System.out.println("Information about the thread Group\n");
        threadGroup.list();  // 输出ThreadGroup的信息

        // 输出线程组中各线程状态
        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        for (int i = 0; i < threadGroup.activeCount(); i++) {
            System.out.printf("Thread %s: %s\n", threads[i].getName(),
                    threads[i].getState());
        }
    }
}
