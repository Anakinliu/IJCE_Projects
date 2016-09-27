package com.youku.demo;

import javax.swing.*;

/**
 * Created by liu_y.
 * On 2016/8/11.
 */
class BirthDate{
    private int day;
    private int month;
    private int year;


    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public BirthDate(int day,int month,int year){
        this.day=day;
        this.month=month;
        this.year=year;
    }

    public void display(){
        System.out.println(day+" - "+month+" - "+year);
    }


}
public class Test {

    public static void main(String[] args) {

        int date=9;

        Test test = new Test();

        BirthDate d1 = new BirthDate(7,7,1970);
        BirthDate d2 = new BirthDate(1,1,2000);

        test.change1(date);
        test.change2(d1);
        test.change3(d2);

        System.out.println("date=" + date);

        d1.display();
        d2.display();
    }

    public void change1(int i){
        i = 1234;

    }

    public void change2(BirthDate b){//传递进来BirthDate的引用类型
        b = new BirthDate(22,2,2004);
    }

    public void change3(BirthDate b){
        b.setDay(22);
    }
}
