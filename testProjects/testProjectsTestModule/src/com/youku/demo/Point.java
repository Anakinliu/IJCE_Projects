package com.youku.demo;

/**
 * Created by liu_y.
 * On 2016/8/11.
 */
public class Point {
    double x;
    double y;
    double z;

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double pToO(Point p){
        return Math.sqrt((p.x-x)*(p.x-x)+(p.y-y)*(p.y-y)+(p.z-z)*(p.z-z));
    }

    public Point(double x,double y,double z ){
        this.x=x;
        this.y=y;
        this.z=z;
    }
    public static void main(String[] args) {

        Point one = new Point(3,3,3);
        Point two = new Point(7,7,7);

        two.setX(3);
        two.setY(0);
        two.setZ(-1);
        //two:  x 3, y 0, z -1

        System.out.println(two.pToO(one));
        //return Math.sqrt((one.x-two.x)*(onr.x-two.x)+(one.y-two.y)*(one.y-two.y)+(one.z-twoz)*(one.z-two.z));
    }
}
