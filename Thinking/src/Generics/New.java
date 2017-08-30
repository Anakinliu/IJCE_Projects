package Generics;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Anakinliu on 2017/8/12.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class New {
    public static <K, V> Map<K, V> map() {
        return new HashMap<>();
    }

    static void f(Map<String, List<? extends Coffee>> input) {

    }

    public static void main(String[] args) {
        Map<Object, List<? extends InputStream>> stringListMap = New.map();
       // f(New.<String, List<Latte>>map());
    }
}
