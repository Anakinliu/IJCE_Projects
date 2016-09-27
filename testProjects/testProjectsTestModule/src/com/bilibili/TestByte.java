package com.bilibili;

/**
 * Created by liu_y.
 * On 2016/9/10.
 */
class Father{
    int x;
    String name;
    protected void setName(String name){//private修饰的类无法继承
        this.name = name;
    }
    private String getName(){
        return name;
    }
    Father(){

    }
}

class Son extends Father{
    Son(String name){
        this.name = name;
    }
}
public class TestByte {
    protected int x;

    public static void main(String[] args) {

        Son soooon = new Son("qte");
         soooon.setName("xxx");
    }
}
