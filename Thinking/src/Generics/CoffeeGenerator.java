package Generics;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.Random;

/**
 * Created by Anakinliu on 2017/8/11.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
interface Generator<T> {
    T next(); //该方法用以产生新的对象
}

class Coffee {
    private static long counter = 0;
    private final long id = counter++;
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}

class Latte extends Coffee {}
class Mocha extends Coffee {}
class Cappuccino extends Coffee {}
class Americano extends Coffee {}
class Breve extends Coffee {}

public class CoffeeGenerator
        implements Generator<Coffee>,
        Iterable<Coffee>
{
    private Class[] types = {Latte.class, Mocha.class,
      Cappuccino.class, Americano.class, Breve.class, };

    private static Random random = new Random(47);

    public CoffeeGenerator() { }

    private int size = 0;
    public CoffeeGenerator(int size)
    {
        this.size = size;
    }

    @Override
    public Coffee next()
    {
        try {
            return (Coffee)
                    types[random.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    class CoffeeIterator implements Iterator<Coffee> {
        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }

        /*
        未实现
         */
        public void remover() {
            throw new UnsupportedOperationException();
        }
    }

    @NotNull
    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    public static void main(String[] args) {
        CoffeeGenerator coffeeGen = new CoffeeGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.println(coffeeGen.next());
        }
        System.out.println("=======================");
        // 实现了 Iterable 的类都可以直接在foreach语句中使用 !
        for (Coffee c : new CoffeeGenerator(5)) {
            System.out.println(c);
        }
        System.out.println(-2147483648);
    }
}
