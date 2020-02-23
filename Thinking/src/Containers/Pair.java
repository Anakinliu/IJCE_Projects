package Containers;

/*
    AUTHOR: linux
    TIME: 2018/5/7
    GOOD LUCK AND NO BUG.
*/
public class Pair<K, V> {
    // public final 为了使Pair对象成为只读的数据传输对象
    public final K key;
    public final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}




