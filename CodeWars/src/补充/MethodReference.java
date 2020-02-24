package 补充;

import java.util.ArrayList;
import java.util.List;

/*
    AUTHOR: linux
    TIME: 2019/11/11
    GOOD LUCK AND NO BUG.
*/
public class MethodReference {
    // 1. Static Method
    public static void test(Object o){
        System.out.println(o);
    }

    void change(String s) {
        System.out.println(s.toLowerCase());
    }

    public static void main(String[] args) {
        List<String> lst = new ArrayList<>();
        lst.add("Tom");
        lst.add("Jerry");
        MethodReference methodReference = new MethodReference();
        lst.forEach(methodReference::change);
        // 相同效果
        lst.forEach(s -> methodReference.change(s));
    }
}
