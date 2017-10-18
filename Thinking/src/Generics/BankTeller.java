package Generics;



import java.util.*;

/**
 * Created by Anakinliu on 2017/8/31.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
class Customer {
    private static long counter = 1;
    private final long id = counter++;
    private Customer() {}
    public String toString() {
        return "Customer" + id;
    }
    // 制造Generator对象的方法
    public static Generator<Customer> generator() {
        return new Generator<Customer>() {
            @Override
            public Customer next() {
                return new Customer();
            }
        };
    }
}
class Teller {
    private static long counter = 1;
    private final long id = counter++;
    private Teller() {}
    public String toString() {
        return "Teller" + id;
    }

    // 只有单个Generator对象
    public static Generator<Teller> generator =
            new Generator<Teller>() {
                public Teller next() {
                    return new Teller();
                }
            };


}
public class BankTeller {
    public static void serve(Teller t, Customer c) {
        System.out.println(t + " serves " + c);
    }

    public static void main(String[] args) {
        Random rand = new Random(66);
        Queue<Customer> line =
                new LinkedList<>();
        Generators.fill(line, Customer.generator(), 15);
        List<Teller> tellers = new ArrayList<>();
        Generators.fill(tellers, Teller.generator, 4);
        for (Customer customer : line) {
            serve(tellers.get(rand.nextInt(tellers.size())), customer);
        }
    }
}
