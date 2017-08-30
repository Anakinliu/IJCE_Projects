package HoldingObjects;

import java.util.ArrayList;

/**
 * Created by Anakinliu on 2017/3/10.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */

class Apple {

}

class Orange {

}

//Apple 子类
class RedApple extends Apple {

}

public class Fruits {
    static ArrayList<Apple> fruits;

    public Fruits () {
        fruits = new ArrayList();

        fruits.add(new Apple());

        fruits.add(new RedApple());
        //! fruits.add(new Orange());
    }

    public static void main(String[] args) {
        Fruits fruits = new Fruits();

        for (int i = 0, length = Fruits.fruits.size(); i<length; i++) {
            //不需要类型转换了
            // !System.out.println((Apple)(Fruits.fruits.get(i)));
            System.out.println((Fruits.fruits.get(i)));
        }
    }
}
