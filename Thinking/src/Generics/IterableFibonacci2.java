package Generics;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * Created by Anakinliu on 2017/8/11.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
/*
Ex7 Ex7 Ex7 Ex7  Ex7  Ex7  Ex7
 */
public class IterableFibonacci2 implements Iterable<Integer>{
    private int n;
    private Fibonacci fibonacci = new Fibonacci();
    public IterableFibonacci2 (int size) {
        n = size;
    }
    @NotNull
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n--;
                return fibonacci.next();
            }
        };
    }

    public static void main(String[] args) {
        for (int i : new IterableFibonacci2(17))
            System.out.println(i);
    }
}
