package Generics;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * Created by Anakinliu on 2017/8/11.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class IterableFibonacci extends Fibonacci
    implements Iterable<Integer>{
    private int n;
    public IterableFibonacci (int count) { n = count;}
    @NotNull
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            /*
            not implemented
             */
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override
            public boolean hasNext() {
               return n > 0; // n是检查计数功能
            }

            @Override
            public Integer next() {
                n--;
                // 返回fibonacci数
                return IterableFibonacci.this.next();
            }
        };
    }

    public static void main(String[] args) {
        for (int i : new IterableFibonacci(18))
            System.out.println(i + " ");
    }
}
