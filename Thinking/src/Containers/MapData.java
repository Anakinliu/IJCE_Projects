package Containers;

import java.util.LinkedHashMap;

/*
    AUTHOR: linux
    TIME: 2018/5/7
    GOOD LUCK AND NO BUG.
*/
public class MapData<K, V> extends LinkedHashMap<K, V> {
    // A single Pair Generator

    public MapData(Generator<Pair<K, V>> gen, int quantity) {
        for (int i = 0; i < quantity; i++) {
            Pair<K, V> p = gen.next();
            put(p.key, p.value);
        }
    }

    // Two Separate generators
    public MapData(Generator<K> genK, Generator<V> genV, int quantity) {
        for (int i = 0; i < quantity; i++) {
            put(genK.next(), genV.next());
        }
    }

    // A key Generator and a single Value
    public MapData(Generator<K> genK, V value, int quantity) {
        for (int i = 0; i < quantity; i++) {
            put(genK.next(), value);
        }
    }

    // An Iterable and value Generator, 按照书上的方法V打印的是地址值
    public MapData(Iterable<K> genK, Generator<Pair<K, V>> genV) {
        for (K key : genK) {
            put(key, genV.next().value);
        }
    }

    // An Iterable and a single value
    public MapData(Iterable<K> genK, V value) {
        for (K key : genK) {
            put(key, value);
        }
    }

    // Generic convenience methods, 减少类型检查
    public static <K, V> MapData<K, V> map(Generator<Pair<K, V>> gen, int quantity) {
        return new MapData<>(gen, quantity);
    }

    public static <K, V> MapData<K, V> map(Generator<K> key, Generator<V> value, int quantity) {
        return new MapData<>(key, value, quantity);
    }

    public static <K, V> MapData<K, V> map(Generator<K> genK, V value, int quantiry) {
        return new MapData<>(genK, value, quantiry);
    }

    public static <K, V> MapData<K, V> map(Iterable<K> genK, Generator<Pair<K, V>> genV) {
        return new MapData<>(genK, genV);
    }

    public static <K, V> MapData<K, V> map(Iterable<K> genK, V value) {
        return new MapData<>(genK, value);
    }
}
