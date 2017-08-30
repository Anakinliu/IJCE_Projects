package ClassDetails;

/**
 * Created by Anakinliu on 2017/7/20.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
class Phone {

}
class Apple extends Phone {

}
public class ClassCasts {
    class StaticInner {
        // the class must be static!
//        static {
//            System.out.println("Static{} here!");
//        }

        public StaticInner() {
            System.out.println("I'm constructor");
        }
    }
    void show () {
        StaticInner staticInner = new StaticInner();
    }
    @SuppressWarnings("unckecked")
    public static void main(String args[]) {
        Phone phone = new Apple();
        Class<Apple> appleClass = Apple.class;

        Apple apple = appleClass.cast(phone);
        Phone phone2 = new Apple();

        //
        System.out.println((phone2 instanceof Apple ));

    }
}
