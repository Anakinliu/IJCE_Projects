package InnerClass;

/**
 * Created by Anakinliu on 2017/3/8.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */


public class Winner {

    private int w;

    public Winner (String name) {
        System.out.println(name);
    }

    class Medal {
        public int x;

        public Medal(int fuckPara) {
            System.out.println(fuckPara);

            //内部类可以直接使用外围类的对象
            System.out.println(w);
        }
    }
}

class JWinner extends Winner.Medal {

    //不可以直接使用外围类(Winner)的对象
    public JWinner(Winner winner) {
        winner.super(9);
        System.out.println(x);

    }
}
