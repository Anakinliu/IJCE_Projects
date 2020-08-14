package chapter2.se2;

public class SafeParkingCash {
    // 停车费
    private static final int cost = 2;
    // 总的收到的停车费
    private long cash;

    public SafeParkingCash() {
        cash = 0;
    }

    //TODO
    public synchronized void vehiclePay() {
        cash += cost;
    }

    public void close() {
        System.out.println("Good Night. Closing accounting...");
        long totalAmount;
        // TODO
//        synchronized (this) {
            totalAmount = cash;
            cash = 0;
//        }

        System.out.println("Today amount is " + totalAmount);
    }
}
