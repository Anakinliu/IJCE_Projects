package chapter1.se6;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class NetworkConnectionsLoader implements Runnable{
    @Override
    public void run() {
        System.out.println("Beginning data sources loading: " + new Date().toString());

        // 模拟资源初始化
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Connection success." + new Date().toString());

    }
}
