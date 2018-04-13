package S1;

import java.util.Scanner;

/**
 * Created by Anakinliu on 18.2.12.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
class Infinity extends Thread{

    private volatile boolean running = true;

    @Override
    public void run() {
        while (running)
            System.out.println("hell" + this.getId());
    }

    public void shutdown() {
        running = false;
    }
}


public class PressToStop {
    public static void main(String[] args) {
        Infinity infinity = new Infinity();
        infinity.start();
        System.out.println("press ENTER to stop!");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        infinity.shutdown();
    }
}
