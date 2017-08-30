package ClassDetails;

/**
 * Created by Anakinliu on 2017/7/17.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
import static print.Print.print;

interface HasBatteries {}
interface Waterproof {}
interface Shoots {}

class Toy {
    // With default constructor commented out will be
    // unable to instantiate this Toy, super of FancyToy:
    // Toy() {}
    int no = 2;
    static int i = 999;
    Toy(int i) {}
    void showSelf() {
        System.out.println("I.m THE Toy !");
    }
    public Toy() {
    }
}

class FancyToy extends Toy
        implements HasBatteries, Waterproof, Shoots {
    static int j = 0;
    FancyToy() {
        super(1);
    }
}

public class ToyTest2 {
    static void printInfo(Class cc) {
        print("===========================");
        print("Class name: " + cc.getName() +
                " is interface? [" + cc.isInterface() + "]");
        print("Simple name: " + cc.getSimpleName());
        print("Canonical name: " + cc.getCanonicalName()); //规范名称
        print("===========================");

    }
    public static void main(String[] args) {
        Class c = null;
//        try {
//            c = Class.forName("ClassDetails.FancyToy");
//        } catch(ClassNotFoundException e) {
//            print("Can't find FancyToy");
//            System.exit(1);
//        }
        c = ClassDetails.FancyToy.class;
        //--------------------------------------------------
        printInfo(c);
        for(Class face : c.getInterfaces())
            printInfo(face);
        Class up = c.getSuperclass();
        Object obj = null;
        try {
            // Requires default constructor in order to
            // create a super or Toy object:
            obj = up.newInstance();
        } catch(InstantiationException e) {
            print("Cannot instantiate");
            System.exit(1);
        } catch(IllegalAccessException i) {
            print("Cannot access");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }
}
