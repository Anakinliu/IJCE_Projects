package com.ThingInJava;

/**
 * Created by liu_y.
 * On 2016/10/21.
 */

 enum Spiciness {
    COLD, SO , HOT
}
//上面创建创建了名为Spiciness的枚举类型，它有三个具名值
//按照惯例应该大写
public class TestEnum {
    public static void main(String[] args) {
        Spiciness felling = Spiciness.COLD;
        Spiciness felling2 = Spiciness.HOT;
        System.out.println(felling);
        System.out.println(felling2.ordinal());
        for (Spiciness s : Spiciness.values()) {
            System.out.println(s);
        }
    }
}
