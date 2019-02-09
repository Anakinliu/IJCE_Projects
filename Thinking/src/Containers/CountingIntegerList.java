package Containers;

import java.util.AbstractList;
import java.util.List;

/*
    AUTHOR: linux
    TIME: 2018/5/7
    GOOD LUCK AND NO BUG.
*/

// 只读List只需实现get()和size()
public class CountingIntegerList extends AbstractList<Integer> {

    private int size;

    public CountingIntegerList(int size) {
        this.size = size < 0 ? 0 : size;
    }

    @Override
    public Integer get(int index) {
        return index;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(Integer integer) {
        size += integer;
        return true;
    }

    public static void main(String[] args) {
        AbstractList<Integer> list = new CountingIntegerList(5);
        list.add(9);
        System.out.println(list);
    }
}
