package com.youku.demo;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by liu_y.
 * On 2016/8/11.
 */
class PointC {

    private double x;
    private double y;

    PointC (double x, double y){
        this.x=x;
        this.y=y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}



class Circle{

    private PointC circleO;//圆心O
    private double radius;

    Circle (PointC p, double r){
        circleO = p;//圆心O
        radius = r;
    }

    Circle(double r){
        circleO = new PointC(0.0, 0.0);//圆心O
        radius = r;
    }

    boolean contains(PointC p){
        double x = p.getX() - circleO.getX();
        double y = p.getY() - circleO.getY();
        if (x*x + y*y > radius * radius)
            return false;
        else
            return true;
    }

    public void setCircleO(double x, double y){
        circleO.setX(x);//圆心O
        circleO.setY(y);//圆心O
    }

    public PointC getCircleO(){
        return circleO;
    }

    public double getRadius(){
        return radius;
    }

    public void setRadius(double r){
            radius = r;
    }

    public double area(){
        return 3.14*radius*radius;
    }

}


public class TestCircle {
    public static void main(String[] args) {

        Circle c1 = new Circle(new PointC(1.0,2.0),2.0);
        Circle c2 = new Circle(5.0);

        System.out.println("c1:(" + c1.getCircleO().getX() + ","
                +c1.getCircleO().getY() + ")," + c1.getRadius());

        System.out.println("c2:(" + c2.getCircleO().getX() + ","
                +c2.getCircleO().getY() + ")," + c2.getRadius());

        System.out.println("c1 area = " + c1.area());

        System.out.println("c2 area = " + c2.area());

        c1.setCircleO(5,6);

        c2.setRadius(9.0);

        System.out.println("c1:(" + c1.getCircleO().getX() + ","
                +c1.getCircleO().getY() + ")," + c1.getRadius());

        System.out.println("c2:(" + c2.getCircleO().getX() + ","
                +c2.getCircleO().getY() + ")," + c2.getRadius());

        System.out.println("c1 area = " + c1.area());

        System.out.println("c2 area = " + c2.area());


        PointC p1 = new PointC (5.2,6.3);
        System.out.println(c1.contains(p1));
        System.out.println(c1.contains(new PointC(10.0,9.0)));
    }
}
