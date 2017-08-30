package InnerClass;

import java.util.function.Function;

/**
 * Created by Anakinliu on 2017/2/9.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
interface Service {
    void mothod1();
    void mothod2();
}
interface ServiceFactory {
    Service getService();
}

class Implements1 implements Service {

    //Function<Double, Double> square =



    @Override
    public void mothod1() {
        System.out.println("1-1");
    }

    @Override
    public void mothod2() {
        System.out.println("1-2");
    }

    public static ServiceFactory getFactory() {
        return Implements1::new;
    }

}

class Implements2 implements Service {
    @Override
    public void mothod1() {
        System.out.println("2-1");
    }

    @Override
    public void mothod2() {
        System.out.println("2-2");
    }

    public Implements2() {
        int x = 9;
    }
    public static ServiceFactory factory =
            new ServiceFactory() {
                @Override
                public Service getService() {
                    return new Implements2();
                }
            };
}





public class Factories {
    public static void serviceConsumer(ServiceFactory fact) {
        Service service = fact.getService();
        service.mothod1();
        service.mothod2();
    }

    public static void main(String[] args) {
        serviceConsumer(Implements1::new);

        serviceConsumer(Implements2.factory);
    }
}
