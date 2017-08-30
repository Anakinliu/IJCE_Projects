package Concurrency;

import java.util.ArrayList;
import java.util.concurrent.*;


/**
 * Created by Anakinliu on 2017/7/29.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
class TaskWithResult implements Callable<Object> {
    private int n;

    public TaskWithResult(int id) {
        this.n = id;
    }

    @Override
    public String call() throws Exception {
        return String.valueOf(fib(n));
    }

    // 输出第n个斐波那契数
    private int fib(int x) {
        if(x < 2) return 1;
        return fib(x - 2) + fib(x - 1);
    }

}
public class MyCallable {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        // Future容器
        ArrayList<Future<Object>> results =
                new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            results.add(executorService.submit(new TaskWithResult(i)));
        }

        // cancel()执行后, isDone()就会一直返回true
        System.out.println(results.get(40).cancel(false));
        System.out.println(results.get(40).isDone());
        System.out.println("===================");

        int i = 0;
        for (Future<Object> fs : results) {
            try {
                i++;
                System.out.println(fs.get().toString());
                System.out.println(results.get(40).isCancelled() + "\t=============" + i);
                // 对已经取消的计算线程进行get()操作会得到异常!
            } catch (InterruptedException | ExecutionException e) {
                System.out.println(e);
            } finally {
                executorService.shutdown();
            }
        }
        System.out.println("END END END END END END END END END END END END");
    }
}
