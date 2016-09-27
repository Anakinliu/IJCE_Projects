package com.bilibili;

import sun.security.provider.SHA;

/**
 * Created by liu_y.
 * On 2016/9/6.
 */
class Shape{
    public double getLocation() {
        return location;
    }

    public void setLocation(double location) {
        this.location = location;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    double location;
    String color;

}

class Circle extends Shape{

}
public class PraticeOne {
    public static void main(String[] args) {
//        double d1 = Double.parseDouble(args[0]);
//        double d2 = Double.parseDouble(args[2]);
//        double d3 = 0;
//
//        if (args[1].equals("+"))
//            d3 = d1 + d2;
//        else if (args[1].equals("x"))
//            d3 = d1 * d2;
//        else if (args[1].equals("-"))
//            d3 = d1 - d2;
//        else if (args[1].equals("/"))
//            d3 = d1 / d2;
//
//        System.out.println(d3);
        Circle c = new Circle();
        c.setColor("green");
        System.out.println(c.getColor());
    }
}
