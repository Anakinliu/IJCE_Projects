package S2;

import java.util.Scanner;

/**
 * shared data
 * two thread
 */

class Processor extends Thread {

    public boolean running = true;

    @Override
    public void run() {
        while (running) {
            System.out.println("Hi");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    关闭线程
     */
    public void shutdown() {
        running = false;
    }
}

public class App1 {
    public static void main(String[] args) {
        Processor processor2 = new Processor();
        processor2.run();

        System.out.println("press to shutdown : ");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        processor2.shutdown();
    }
}
