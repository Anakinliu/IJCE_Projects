package chapter1.se11;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RenXingThreadFactory {

    private int counter;
    private List<String> stats;
    private String name;

    public RenXingThreadFactory(String name) {
        this.name = name;
        counter = 0;
        stats = new ArrayList<>();
    }

    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r, name + "_Thread_" + counter);
        counter ++;
        // 记录线程信息，线程运行完也会保留
        stats.add(String.format("Crated thread %d with name %s on %s\n",
                thread.getId(), thread.getName(), new Date()));
        return thread;
    }

    public List<String> getStats() {
        return stats;
    }
}
