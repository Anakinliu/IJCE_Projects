package chapter1.se8;

public class Task implements Runnable{

    @Override
    public void run() {
        /*
        * 抛出非检查异常
        * */
        makeException();
        while (true) {
            System.out.println("Running");
        }
    }

    private void makeException() {
        int numero = Integer.parseInt("UFO");
    }
}
