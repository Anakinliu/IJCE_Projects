package com.zzxy.demo;

/**
 * Created by liu_y.
 * On 2016/8/21.
 */
class Anim{
    String name;
    Anim(String name){
        this.name = name;
    }
}
class Shark extends Anim{
    String name;
    int age;
    Shark(String n,int age){
        super(n);
        name = n;
        this.age = age;
    }
    public boolean equals(Object obj){
        if (obj == null){
            return false;
        }
        else {
            if (obj instanceof Shark){
               Shark s = (Shark)obj;
                if (s.name == this.name && s.age == this.age){
                    return true;
                }
            }
        }
        return false;
    }
}
public class Equal {

    public static void main(String[] args) {
        Shark s1 = new Shark("z", 1);
        Anim a2 = new Shark("a shark", 2);
        System.out.println(a2.name);

        System.out.println(a2 instanceof Anim);
        System.out.println(a2 instanceof Shark);
        System.out.println("----------------");
        Shark s2 = new Shark("z", 1);
        System.out.println(s1.equals(s2));

        String s3 = new String("ss");
        String s4 = new String("ss");
        System.out.println(s3.equals(s4));
    }
}
