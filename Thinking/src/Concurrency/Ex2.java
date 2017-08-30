package Concurrency;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static print.Print.print;
import static sun.misc.Version.println;

/**
 * Created by Anakinliu on 2017/7/28.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
class Ex2FibonacciA implements Runnable {
    private int n = 0;
    public Ex2FibonacciA(int n) {
        this.n = n;
    }

    // 输出第n个斐波那契数
    private int fib(int x) {
        if(x < 2) return 1;
        return fib(x - 2) + fib(x - 1);
    }
    public void run() {
        for(int i = 0; i < n; i++)
            print(fib(i) + " ");
        println();
    }
}

class Ex2FibonacciB implements Runnable {
    private int n = 0;
    public Ex2FibonacciB(int n) {
        this.n = n;
    }
    private int fib(int x) {
        if(x < 2) return 1;
        return fib(x - 2) + fib(x - 1);
    }
    public void run() {
        for(int i = 0; i < n; i++)
            print(fib(i) + " ");
        println();
    }
}

class Ex2FibonacciC implements Runnable {
    private int n = 0;
    public Ex2FibonacciC(int n) {
        this.n = n;
    }
    private int fib(int x) {
        if(x < 2) return 1;
        return fib(x - 2) + fib(x - 1);
    }
    public void run() {
        for(int i = 0; i < n; i++)
            print(fib(i) + " ");
        println();
    }
}

class Ex2FibonacciD implements Runnable {
    private int n = 0;
    public Ex2FibonacciD(int n) {
        this.n = n;
    }
    private int fib(int x) {
        if(x < 2) return 1;
        return fib(x - 2) + fib(x - 1);
    }
    public void run() {
        for(int i = 0; i < n; i++)
            print(fib(i) + " ");
        println();
    }
}

public class Ex2 implements Executor {
    private static int fib(int x) {
        if(x < 2) return 1;
        return fib(x - 2) + fib(x - 1);
    }
    public static void main(String[] args) {
//        new Ex2FibonacciA(150).run();

//        Thread f2 = new Thread(new Ex2FibonacciB(150));
//        Thread f3 = new Thread(new Ex2FibonacciC(150));
//        Thread f4 = new Thread(new Ex2FibonacciD(150));
//
//        f2.start();
//        f3.start();
//        f4.start();

//        Executor executor = new Ex2();
//        executor.execute(new Ex2FibonacciA(12));
//        executor.execute(new Ex2FibonacciB(15));

//        ExecutorService exec = Executors.newCachedThreadPool();
//        for (int i = 0; i < 5; i++) {
//            exec.execute(new Ex2FibonacciB(5));
//        }
//        exec.shutdown();
//        exec.execute(new Ex2FibonacciA(9));

//        ExecutorService exec2 = Executors.newSingleThreadExecutor();
//        for (int i = 0; i < 5; i++) {
//            exec2.execute(new Ex2FibonacciB(10));
//        }
//        exec2.shutdown();
        System.out.println(fib(4));
    }

    @Override
    public void execute(@NotNull Runnable command) {
        new Thread(command).start();
    }
}