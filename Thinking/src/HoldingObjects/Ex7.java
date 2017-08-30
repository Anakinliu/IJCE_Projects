package HoldingObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Anakinliu on 2017/3/22.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
class Dog {
    String name;

    Dog(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
public class Ex7 {
    static Dog[] dogs = new Dog[3];
    static {
        dogs[0] = new Dog("1");
        dogs[1] = new Dog("2");
        dogs[2] = new Dog("3");
    }

    Ex7() {

    }

    public static void main(String[] args) {
        List<Dog> dogList = new ArrayList<>();
        for (int i =0,length = dogs.length; i<length; i++) {
            dogList.add(dogs[i]);
            System.out.println(dogs[i]);
        }
        /*
        此方法与Collection.toArray（）结合使用，
        作为基于阵列和基于集合的API之间的桥梁。
        返回的列表是可序列化的，并实现了RandomAccess。
         */
        dogList.addAll(Arrays.asList(dogs));



        List sub2_6 = dogList.subList(2, 6); //不包含下标为6的对象

        System.out.println("sub2_6:" + sub2_6);

        List<Dog> copy = new ArrayList<Dog>(sub2_6);


        // 注意,虽然sub2_6只有四个元素,而dogList有六个,但是因为后三个是重复添加的
        // 所以也会被删除!!!

       // dogList.removeAll(sub2_6);

        // 这样做会使得sub2_6成为空列表
        sub2_6.clear();

        // 此时sub2_6已经"不再存在了",更不是一个空列表
        System.out.println("after sub2_6.clear(): " + sub2_6);


        System.out.println("dogList: " + dogList + "对子列表做的修改对父列表也会生效");


        for (Dog e : dogList) {
            System.out.println(e);
        }

        System.out.println("remove start!");
        Iterator<Dog> iterator = dogList.iterator();
        while (iterator.hasNext()) {
            iterator.next();

            // 需要next()返回
            iterator.remove();

        }
        System.out.println("remove stop!");

        for (Dog e : dogList) {
            System.out.println(e);
        }
    }

}
