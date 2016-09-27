package com.bilibili;

/**
 * Created by liu_y.
 * On 2016/9/3.
 */
class Students {
    public String name;
    public int number;
    Students (String na,int nu) {
        name = na;
        number = nu;
    }
}
public class TestArr {
    public static void main(String[] args) {
        double x =43.2;
        float y = 8.8f;
        Students[] S;
        S = new Students[6];
        S[0] = new Students("quan", 3);
        S[1] = new Students("quan",3);

        //数组元素是引用类型时，这些元素在使用时都需要实例化
        S[0].name = "liu";
        S[1].name = "liu";

        System.out.println(S[0].name);
        System.out.println(S.length);
    }
}
