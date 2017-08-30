package Generics;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Anakinliu on 2017/8/11.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
/*
自定义了泛型容器, 可以随机产生元素
 */
public class RandomList<T> {
    private ArrayList<T> storage = new ArrayList<>();
    private Random random = new Random();
    public void add(T item) {
        storage.add(item);
    }
    public T select() {
        return storage.get(random.nextInt(storage.size()));
    }

    public static void main(String[] args) {
        RandomList<Integer> randomList = new RandomList<>();
        for (Integer s : new Integer[]{1, 2, 3, 4, 5, 6,34,454, 45,})
            randomList.add(s);
        for (int i = 0; i < 3; i++)
            System.out.println(randomList.select());
    }
}
