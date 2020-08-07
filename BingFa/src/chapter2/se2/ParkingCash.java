package chapter2.se2;

public class ParkingCash {
    // 停车费
    private static final int cost = 2;
    // 总的收到的停车费
    private long cash;

    public ParkingCash() {
        cash = 0;
    }

    public void vehiclepay() {
        cash += cost;
    }

    public void close() {
        System.out.println("Good Night. Closing accounting...");
        long totalAmount;
        totalAmount = cash;
        cash = 0;
        System.out.println("Today amount is " + totalAmount);
    }
}
