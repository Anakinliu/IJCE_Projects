package S1;

/**
 * Created by Anakinliu on 18.2.12.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
class Runner implements Runnable {
    public String name;
    public Runner(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        for (int i=0; i < 10; i++) {
            System.out.println(name + " : " + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class DoubleThread {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runner("t1"));
        Thread thread2 = new Thread(new Runner("t2"));
        thread1.start();
        thread2.start();
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("333333");
            }
        });
        thread3.start();
    }
}
