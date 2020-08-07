package chapter1.se2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        System.out.println("Minimum Priority : " + Thread.MIN_PRIORITY);
        System.out.println("Normal Priority : " + Thread.NORM_PRIORITY);
        System.out.println("Maximum Priority : " + Thread.MAX_PRIORITY);
        Thread threads[];
        Thread.State status[];
        threads = new Thread[10];
        status = new Thread.State[10];

        /*
        * 创建10个Thread对象，
        * 分别用来执行10个Calculator任务。再
        * 创建两个数组，用来保存Thread对象及其State对象。
        * 将5个线程设置为最大优先级，另5个线程设置为最小优先级：
        * */
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Calculator());
            if ((i % 2) == 0) {  // 0 2 4 6 8 最高优先级
                threads[i].setPriority(Thread.MAX_PRIORITY);
            }else {  // 1 3 5 7 9 最低优先级
                // 超过1-10会报错
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("My Thread" + i);
        }

        // 将一些必要的信息保存到文件中
        try (FileWriter file = new FileWriter("log.txt");
             PrintWriter pw = new PrintWriter(file);) {
            for (int i = 0; i < 10; i++) {
                pw.println("Main: Status of Thread" + i + ":" + threads[i].getState());
                status[i] = threads[i].getState();
            }
            for (int i = 0; i < 10; i++) {
                threads[i].start();
            }
            boolean finish = false;
            while (!finish) {
                for (int i = 0; i < 10; i++) {
                    if (threads[i].getState() != status[i]) {
                        writeThreadinfo(pw, threads[i], status[i]);
                        status[i] = threads[i].getState();
                    }
                }
                finish = true;
                for (int i = 0; i < 10; i++) {
                    finish = finish && (threads[i].getState() == Thread.State.TERMINATED);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeThreadinfo(PrintWriter pw, Thread thread, Thread.State state) {
        pw.printf("Main : ID %d - %s \n", thread.getId(), thread.getName());
        pw.printf("Main : Priority: %d \n", thread.getPriority());
        pw.printf("Main : Old State: %s \n", state);
        pw.printf("Main : New State; %s \n", thread.getState());
        pw.println("Main : ***************************************\")");
    }
}
