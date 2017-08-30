package HoldingObjects;

import java.util.*;

/**
 * Created by Anakinliu on 2017/3/19.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class newCollection {
    String movies[] = {"Snow White", "Star Wars", "Resident Evil"};

    int key =0;

    public String next() {
        if (key == movies.length) {
            System.out.println("=================");
            key = 0;
        }
        return movies[key++];
    }

    public String[] fill(String[] fill) {
        for (int i=0; i<fill.length; i++) {
            fill[i] = next();
        }

        return fill;
    }

    //返回容器用来打印
    public Collection fill(Collection<String> cs) {
        for (int i=0; i<movies.length; i++) {
            cs.add(next()); //并不是从movies[0]开始add的!

        }

        //toArray方法是一个重载方法,它可以接受其包含的元素类型的数组(需要通过类型检查),
        //如果参数数组太小,toArray方法会修改到合适尺寸!
        String[] ins = cs.toArray(new String[1]);
        for (String i : ins) {
            System.out.println(i);
        }
        System.out.println(ins.length);
        return cs;
    }

}

class EX4 {
    public static void main(String[] args) {
        newCollection nC = new newCollection();

        String[] s = new String[4];

        nC.fill(s);

        for (String e : s) {
            System.out.println(e);
        }
        System.out.println();

        System.out.println("ArrayList" + nC.fill(new ArrayList<String>()));

        System.out.println("LinkedList" + nC.fill(new LinkedList<String>()));

        System.out.println("HashSet" + nC.fill(new HashSet<String>()));

        System.out.println("LinkedHashSet" + nC.fill(new LinkedHashSet<String>()));

        System.out.println("TreeSet" + nC.fill(new TreeSet<String>()));


    }
}
