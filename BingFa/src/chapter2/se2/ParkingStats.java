package chapter2.se2;

public class ParkingStats {
    private long numberCars;
    private long numberMotocycles;
    private ParkingCash cash;

    public ParkingStats(ParkingCash cash) {
        numberCars = 0;
        numberMotocycles = 0;
        this.cash = cash;
    }


    /*
    * 实现一系列机动车驶入或者离开时需要执行的方法，现金总额将在机动车驶出时增加
    * */
    public void carComeIn() {
        numberCars ++;
    }

    public void carGoOut() {
        numberCars--;
        cash.vehiclepay();
    }

    public void motoComeIn() {
        numberMotocycles++;
    }

    public void motoGoOut() {
        numberMotocycles --;
        cash.vehiclepay();
    }

    public long getNumberCars() {
        return numberCars;
    }

    public long getNumberMotocycles() {
        return numberMotocycles;
    }
}
