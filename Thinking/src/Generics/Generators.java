package Generics;

import java.util.*;

/**
 * Created by Anakinliu on 2017/8/12.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
/*
interface Generator<T> {
    T next(); //该方法用以产生新的对象
}
 */
public class Generators
{
    public static <T> Collection<T> fill (
            Collection<T> collection, Generator<T> generator, int size)
    {
        for (int i = 0; i < size; i++) {
            collection.add(generator.next());
        }
        return collection;
    }

    public static <T> List<T> fill (
            List<T> collection, Generator<T> generator, int size)
    {
        for (int i = 0; i < size; i++) {
            collection.add(generator.next());
        }
        return collection;
    }

    public static <T> Set<T> fill (
            Set<T> collection, Generator<T> generator, int size)
    {
        for (int i = 0; i < size; i++) {
            collection.add(generator.next());
        }
        return collection;
    }

    public static <T> Queue<T> fill (
            Queue<T> collection, Generator<T> generator, int size)
    {
        for (int i = 0; i < size; i++) {
            collection.add(generator.next());
        }
        return collection;
    }
    public static <T> LinkedList<T> fill (
            LinkedList<T> collection, Generator<T> generator, int size)
    {
        for (int i = 0; i < size; i++) {
            collection.add(generator.next());
        }
        return collection;
    }

    public static void main(String[] args) {
        Collection<Coffee> coffeeCol =
                fill(new ArrayList<Coffee>(), new CoffeeGenerator(), 2);
        System.out.println(coffeeCol);
        LinkedList<Coffee> coffeeList =
                fill(new LinkedList<>(), new CoffeeGenerator(), 3);
        System.out.println(coffeeList);
        Queue<Coffee> coffeeQueue =
                fill(new ArrayDeque<>(), new CoffeeGenerator(), 3);
        System.out.println(coffeeQueue);
        Set<Coffee> coffeeSet =
                fill(new HashSet<>(), new CoffeeGenerator(), 1);
        System.out.println(coffeeSet);
        // Q: hashset行, treeset就不行?
        // A: treeset需要实现compareTo方法, hashSet不需要

    }
}


