package Containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    AUTHOR: linux
    TIME: 2018/5/7
    GOOD LUCK AND NO BUG.
*/
class StringAddress {
    private String s;

    public StringAddress(String s) {
        this.s = s;
    }

    public String toString() {
        return super.toString() + " " + s;
    }
}

public class FillingLists {
    public static void main(String[] args) {
        // Collections类直接继承Object类, 含有多个便利的方法

        // 两种使用单个对象的引用来填充Collection的方式
        // 第一种
        List<StringAddress> list = new ArrayList<>(
                Collections.nCopies(4, new StringAddress("Hello")));
        // 从输出中可以看到所有引用都指向同一个对象
        System.out.println("list is : " + list);
        // 第二种
        Collections.fill(list, new StringAddress("World!"));
        // 同样, 从输出中可以看到所有引用都指向同一个对象
        System.out.println("list is: " + list);
    }
}
