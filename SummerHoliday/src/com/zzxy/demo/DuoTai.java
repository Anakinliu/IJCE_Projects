package com.zzxy.demo;

/**
 * Created by liu_y.
 * On 2016/8/21.
 */
abstract class Plant{
    int height;
    String flowerColor;
    public abstract void showFlower();
}

abstract class GouYiBa extends Plant{
//    public void showFlower(){
//        System.out.println("Gou Yi Ba Hua......");
//    }

}

class CheQian extends Plant{
    public void showFlower(){
        System.out.println("Che Qian......");
    }
}

public class DuoTai {
    public void Yang(Plant a){
        a.showFlower();
    }
    public static void main(String[] args) {

      //  Plant p = new Plant();
        CheQian cq = new CheQian();
       // GouYiBa gyb = new GouYiBa();
        DuoTai dt = new DuoTai();

       // dt.Yang(p);
        dt.Yang(cq);
       // dt.Yang(gyb);
    }
}
