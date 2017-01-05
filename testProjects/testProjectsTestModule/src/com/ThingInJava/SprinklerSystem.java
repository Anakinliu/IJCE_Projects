package com.ThingInJava;

/**
 * Created by liu_y.
 * On 2016/10/23.
 */
class WaterSource {
    private String s;
    WaterSource() {
        System.out.println("WaterSource()");
        s = "Constructed";
    }
    public String toString () {
        return s;
    }
}
public class SprinklerSystem {
    private String value1, value2, value3, value4;
    private WaterSource source = new WaterSource();
    private int i;
    private float f;
    {i = 47;}//实例初始化！！！！！！！！
    public String toString () {
        return
                "value1 = " + value1 + " " +
                        "value2 = " + value2 + " " +
                        "value3 = " + value3 + " " +
                        "value4 = " + value4 + " " +
                        "i = " + i + " " + "f = " + f + " " +
                        "source = " + source;
    }
    public static void main(String[] args) {
        SprinklerSystem sprinklers = new SprinklerSystem();
        System.out.println("next statement");
        System.out.println(sprinklers.source);
        System.out.println(sprinklers.i);
    }
}
