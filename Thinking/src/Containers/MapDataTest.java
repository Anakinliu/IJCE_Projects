package Containers;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/*
    AUTHOR: linux
    TIME: 2018/5/7
    GOOD LUCK AND NO BUG.
*/
class Letters implements Generator<Pair<Integer, String>>, Iterable<Integer> {

    private int size = 9;
    private int number = 1;
    private char letter = 'A';

    // 实现Generator接口的方法
    @Override
    public Pair<Integer, String> next() {
        // 原来char类型还能用自增运算符...
        return new Pair<>(number++, "" + letter++);
    }

    // 实现Iterable接口的方法
    @NotNull
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return number < size;
            }

            @Override
            public Integer next() {
                return number++;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
public class MapDataTest {
    public static void main(String[] args) {
        System.out.println(MapData.map(new Letters(), 500));

        System.out.println(MapData.map(new Letters(), new Letters()));

        System.out.println(MapData.map(new Letters(), "SS"));
    }
}
