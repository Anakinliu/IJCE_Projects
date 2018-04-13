/*
某个线程的错误不影响别的线程
 */
class BadThread extends Thread{
    private String name;
    private int count = 1;
    public BadThread(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        if (name.equals("t2")) {
            //
            System.out.println(3/0);
        }
        while (count < 5) {
            count++;

            System.out.println(name);
        }
    }
}
public class MultiThreadingException {
    public static void main(String[] args) {
        BadThread thread1 = new BadThread("t1");
        thread1.start();
        BadThread thread2 = new BadThread("t2");
        thread2.start();
        BadThread thread3 = new BadThread("t3");
        thread3.start();

    }
}
