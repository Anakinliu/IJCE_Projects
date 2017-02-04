package polymorphismANDinterface;




/**
 * Created by Anakinliu on 2017/1/30.
 */

//添加 Runnable接口 很容易

interface Cycle extends Runnable {
    //void run();
}

interface CycleFactory {
    Cycle getCycle();
}

//------------

class Unicycle implements Cycle {
    public void run() {
        while(true) {
            System.out.println(Thread.currentThread().getName() + " running!!");
            try {
                Thread.sleep(0,1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "Unicycle";
    }
}

class UnicycleFactory implements CycleFactory {
    @Override
    public Cycle getCycle() {
        return new Unicycle();
    }
}

//----------------

class Bicycle implements Cycle {
    public void run() {
        while(true) {
            System.out.println("Bicycle running");
            try {
                Thread.sleep(0,1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString()
    {
        return "Bicycle";
    }
}

class BicycleFactory implements CycleFactory {

    @Override
    public Cycle getCycle()
    {
        return new Bicycle();
    }
}

//----------------------

class Tricycle implements Cycle {
    public void run() {
        while(true)
            System.out.println("Tricycle running");
    }


    public String toString() {
        return "Tricycle";
    }
}

class TricycleFactory implements CycleFactory {
    @Override
    public Cycle getCycle() {
        return new Tricycle();
    }
}

public class Pratice18 {
//    public static void cycleRun(CycleFactory cf) {
//        Cycle cycle = cf.getCycle();
//        cycle.run();
//    }

    public static void main(String[] args) {
//        cycleRun(new UnicycleFactory());
//        cycleRun(new BicycleFactory());
//        cycleRun(new TricycleFactory());

        Thread unicycle = new Thread((new UnicycleFactory()).getCycle(),"unicycleThread =-=");

        unicycle.start();

        Thread bicycle = new Thread((new BicycleFactory()).getCycle(),"bicycleThread =-=");

        bicycle.start();

        Thread tricycle = new Thread((new TricycleFactory()).getCycle(),"TricycleThread =-=");

        //tricycle.start();

    }
}
