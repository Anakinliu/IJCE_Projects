package chapter1.se4;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        FileSearch searcher = new FileSearch(
                "C:\\Windows", "explorer.exe"
        );
        Thread task = new Thread(searcher);
        task.start();

        // 等待10s后中断线程
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        task.interrupt();
    }
}
