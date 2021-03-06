package chapter2.se2;

public class Main {
    public static void main(String[] args) {
        ParkingCash cash = new ParkingCash();
        ParkingStats stats = new ParkingStats(cash);
        System.out.println("###Parking start###");
        int numberSensors = 8;
        Thread threads[] = new Thread[numberSensors];
        for (int i = 0; i < numberSensors; i++) {
            Sensor sensor = new Sensor(stats);
            Thread thread = new Thread(sensor);
            thread.start();
            threads[i] = thread;
        }
        for (int i = 0; i < numberSensors; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("###Parking end###");
        System.out.println("Number of cars " + stats.getNumberCars() + " should be 0");
        System.out.println("Number of motos " + stats.getNumberMotocycles() + " should be 0");
        cash.close();
        System.out.println("Today amount should be 480");
    }
}
