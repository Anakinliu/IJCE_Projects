package com.ZZ;

/**
 * Created by liu_y.
 * On 2016/10/9.
 */


import java.util.Calendar;
import java.util.GregorianCalendar;


public class Person {

    // person的属性
    private String name;
    private int birthYear ;
    private int birthMonth ;
    private int birthDay ;
    private String gender;//性别,woman or man
    private Person partner;//现有对象
    //	Calendar birthday;
//	Calendar today;
    public Person () {

    }
    public Person (String name,String gender,int y, int m, int d,Person partner) {
        this.name = name;
        this.gender = gender;
        birthYear = y;
        birthMonth = m;
        birthDay = d;
        this.partner = partner;
    }
    /*
     * 获取年龄的方法
     */
    public int getRealAge() {
        Calendar today = new GregorianCalendar();
        //得到目前年月日
        int todayYear = today.get(Calendar.YEAR);
        int todayMonth = today.get(Calendar.MONTH + 1);//比实际少一。。。。
        int todayDay = today.get(Calendar.DAY_OF_MONTH);
//		int birthYear = birthday.get(Calendar.YEAR);
//		int birthMonth = birthday.get(Calendar.MONTH);
//		int birthDay = birthday.get(Calendar.DAY_OF_MONTH);
        if (todayMonth > birthMonth) {
            return todayYear - birthYear;
        } else if (todayMonth < birthMonth) {
            return todayYear - birthYear - 1;
        } else if (todayDay >= birthDay) {
            return todayYear - birthYear;
        } else {
            return todayYear - birthYear - 1;
        }
    }
    /**
     * marry(Person p)方法，代表当前对象能否和p结婚
     */
    public boolean marryWith(Person p) {
        if (this.gender.equals(p.gender)) {
            System.out.println("同性不能结婚！");
            return false;
        }
        if (this.partner != null || p.partner != null) {
            System.out.println("某一方已婚，不能再结婚！");
            return false;
        }
        if (!this.wasOverAgeForMarry()) {
            System.out.println("对不起，您没有达到结婚年龄，不能结婚！");
            return false;
        }
        if (!p.wasOverAgeForMarry()) {
            System.out.println("对不起，您的对象没有达到结婚年龄，不能结婚！");
            return false;
        }
        this.partner = p;
        p.partner = this;
        System.out.println("恭喜，" + this.name + "和" + p.name + "结婚成功！");
        return true;
    }

    /**
     *
     * 判断是否超过结婚年龄
     */
    public boolean wasOverAgeForMarry() {
        if (this.gender=="man" && this.getRealAge() >= 22) {
            return true;
        }
        if (this.gender=="woman" && this.getRealAge() >= 20) {
            return true;
        }
        return false;
    }
}
class Test {
    public static void main(String[] args) {
        Person man1 = new Person("xx","man",1995,10,1,null);
        Person woman1 = new Person("oo","woman",1994,10,1,null);
        woman1.marryWith(man1);
    }
}

