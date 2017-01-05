package com.ThingInJava;

/**
 * Created by liu_y.
 * On 2016/10/23.
 */
public class Cleanser {

    private  String s = "Cleanser";
    public void append (String a) {
        s += a;
    }
    public void srub () {
        append("srub()");
    }
    public String toString (){
        return s;
    }
    public static void main(String[] args) {
    }
}

class  Detergent extends Cleanser {
    public void srub(){
        append("Detergent.scrub()");
        super.srub();
    }
}
