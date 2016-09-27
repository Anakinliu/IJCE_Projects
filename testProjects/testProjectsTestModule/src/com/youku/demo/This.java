package com.youku.demo;

/**
 * Created by liu_y.
 * On 2016/8/12.
 */
public class This {
    private int x;

    This(int x){
        this.x = x;
    }

    This addThis(){
        ++x;
        return this;
    }
    public static void main(String[] args) {
        This t = new This(100);


        System.out.println(t.addThis().addThis().addThis().x);
    }
}
