package chapter2.se2;

public class SafeParkingStats {
    private long numberCars;
    private long numberMotocycles;
    private SafeParkingCash cash;

    // final 可以在构造器里初始化
    private final Object controlCars, controlMotorcycles;

    public SafeParkingStats(SafeParkingCash cash) {
        numberCars = 0;
        numberMotocycles = 0;
        this.cash = cash;

        controlCars = new Object();
        controlMotorcycles = new Object();
    }


    /*
     * 实现一系列机动车驶入或者离开时需要执行的方法，现金总额将在机动车驶出时增加
     * */
    public void carComeIn() {
        synchronized (controlCars) {
            numberCars ++;
        }

    }

    public void carGoOut() {
        synchronized (controlCars) {
            numberCars--;
        }
        cash.vehiclePay();
    }

    public void motoComeIn() {
        synchronized (controlMotorcycles) {
            numberMotocycles++;
        }
    }

    public void motoGoOut() {
        synchronized (controlMotorcycles) {
            numberMotocycles --;
        }
        cash.vehiclePay();
    }

    public long getNumberCars() {
        return numberCars;
    }

    public long getNumberMotocycles() {
        return numberMotocycles;
    }
}
