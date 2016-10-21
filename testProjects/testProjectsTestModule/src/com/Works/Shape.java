package com.Works;

import java.util.Arrays;

/**
 * Created by liu_y.
 * On 2016/10/9.
 * 3.定义一个抽象类Shape，其中包括一个抽象方法area（）,
 * 设计“矩形”、“圆”、“三角形”等类继承Shape类,
 * 其area（）方法分别表示计算矩形面积、圆面积、三角形的面积。
 * 分别创建代表“矩形”、“圆”、“三角形”的三个对象存入一个Shape类型的数组中，
 * 通过调用area（）方法将数组中各类图形的面积输出。
 */
public abstract class Shape {

    protected int edgeCounts;
    protected double[] edgesLength;

    public void buildShape (int edgeCounts) {
        edgesLength = new double[edgeCounts];
    }

    public abstract double area();

}

class Rectangle extends Shape {

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        edgeCounts = 4;
        buildShape(edgeCounts/2);
        edgesLength[0] = width;
        edgesLength[1] = length;
    }

    public double getWidth() {
        return edgesLength[0];
    }

    public void setWidth(double width) {
        edgesLength[0] = width;
    }

    public double getLength() {
        return edgesLength[1];
    }

    public void setLength(double length) {
        edgesLength[1] = length;
    }

    @Override
    public double area() {
        return edgesLength[0] * edgesLength[1];
    }

    public String toString () {
        return "正方形： ";
    }
}

class Circular extends Shape {

    public Circular() {
    }

    public Circular(double radius) {
        edgeCounts = 1;
        buildShape(edgeCounts);
        edgesLength[0] = radius;
    }

    public double getRadius() {
        return edgesLength[0];
    }

    public void setRadius(double radius) {
        edgesLength[0] = radius;
    }

    @Override
    public double area() {
        return Math.PI * edgesLength[0] * edgesLength[0];
    }

    public String toString() {
        return "圆形： ";
    }
}

class Triangle extends Shape {

    public Triangle() {
    }

    public Triangle(double edge1, double edge2, double edge3) {
        edgeCounts = 3;
        buildShape(edgeCounts);
        edgesLength[0] = edge1;
        edgesLength[1] = edge2;
        edgesLength[2] = edge3;
    }

    public double[] getTriEdges() {
        return this.edgesLength;
    }
    public boolean isTriangle () {
        Arrays.sort(edgesLength);
        if (edgesLength[0] + edgesLength[1] > edgesLength[2]) {
            return true;
        }
        else {
            return false;
        }
    }
    private double getP() {
        /*
        * 海伦公式：S = √[p(p - a)(p - b)(p - c)]
        *.p = (a + b + c)/2
        */
        if (isTriangle()) {
            return (edgesLength[0] + edgesLength[1] + edgesLength[2]) / 2;
        }
        else {
            return 0.0;
        }

    }
    @Override
    public double area() {

        return Math.sqrt(getP() * (getP() - edgesLength[0]) * (getP() - edgesLength[1]) * (getP() - edgesLength[2]));
    }
    public String toString() {
        return "三角形： ";
    }
}

/**
 * Created by liu_y.
 * On 2016/10/9.
 * 3.定义一个抽象类Shape，其中包括一个抽象方法area（）,
 * 设计“矩形”、“圆”、“三角形”等类继承Shape类,
 * 其area（）方法分别表示计算矩形面积、圆面积、三角形的面积。
 * 分别创建代表“矩形”、“圆”、“三角形”的三个对象存入一个Shape类型的数组中，
 * 通过调用area（）方法将数组中各类图形的面积输出。
 */

class TestShape {
    public static void show() {
        Shape[] sharpArray;
        sharpArray = new Shape[3];
        sharpArray[0] = new Rectangle(2.5,2);
        sharpArray[1] = new Circular(2);
        sharpArray[2] = new Triangle(3,4,5);
        for (int i=0; i<3; i++) {
            System.out.println(sharpArray[i].toString() + "面积： " + sharpArray[i].area());
        }
    }
    public static void main(String[] args) {
        show();
    }
}
