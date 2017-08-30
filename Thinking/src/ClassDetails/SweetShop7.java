package ClassDetails;

/**
 * Created by Anakinliu on 2017/7/18.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
class Candy {

    static int i =9;
    static {

        System.out.println("Candy loading" + i);
    }
    public Candy() {
        i = 10;
        System.out.println("i = " + i);
    }
}
public class SweetShop7 {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java SweetShop7 Candy");
            System.exit(0);
        }
        Class c = null;
        try {
            Class.forName("ClassDetails." + args[0]);
            System.out.println("enjoy !");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
