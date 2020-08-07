package chapter2.se2;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/*
* 该类模拟机动车在停车场中的移动情况
* */
public class Sensor implements Runnable {
    private ParkingStats stats;

    public Sensor(ParkingStats stats) {
        this.stats = stats;
    }

    @Override
    public void run() {
/*
* 该方法模拟两辆汽车和一辆摩托车驶入停车场
* 并随后驶离停车场的情况。
* 每个传感器将执行这个动作10次
* */
        for (int i = 0; i < 10; i++) {
            // 修改停车状态
            stats.carComeIn();
            stats.carComeIn();

            // 停车中
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stats.motoComeIn();

            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 出 停车场，交费
            stats.motoGoOut();
            stats.carGoOut();
            stats.carGoOut();

        }
    }
}
