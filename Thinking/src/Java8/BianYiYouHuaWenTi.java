package Java8;

/**
 * Created by Anakinliu on 2017/7/27.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
import kotlin.jvm.Synchronized;

import java.util.concurrent.*;

public class BianYiYouHuaWenTi {

    private static boolean stopRequested;


    public static synchronized boolean isStopRequested() {
        return stopRequested;
    }


    public static synchronized void setStopRequested(boolean stopRequested) {
        BianYiYouHuaWenTi.stopRequested = stopRequested;
    }

    public static void main(String[] args) throws Exception {
        int[] s = new int[8];
        Thread t = new Thread(new Runnable() {
            public void run() {
                int i = 0;
                while (!isStopRequested())
                    i++;
            }
        });
        t.start();
        TimeUnit.SECONDS.sleep(1);
        if (!isStopRequested()) {
            setStopRequested(true);

        }
    }
}
