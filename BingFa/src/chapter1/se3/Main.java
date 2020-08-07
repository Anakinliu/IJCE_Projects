package chapter1.se3;

public class Main {
    public static void main(String[] args) {
        Thread task = new PrimeGenerator();
        task.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        task.interrupt();


        System.out.println("Main: Status of the thread: " + task.getState());
        System.out.println("Main: isInterrupted : " + task.isInterrupted());
        System.out.println("Main: is Alive: " + task.isAlive());
    }
}
