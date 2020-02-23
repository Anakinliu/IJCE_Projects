package kyu6;

/*
    AUTHOR: linux
    TIME: 2020/2/19
    GOOD LUCK AND NO BUG.
*/
/*
https://www.codewars.com/kata/566be96bb3174e155300001b

以VKM/H向上垂直抛出球，t时刻高度h为h = v*t - 0.5*g*t*t，
h = v*t - 0.5*g*t*t
设备会每十分之一秒记录一次球的高度。
（0，0.0），（1，0.367 ...），（2，0.637 ...），（3，0.808 ...），（4，0.881 ..）...
第一个数字是时间以十分之一秒为单位，第二个数字以米为单位。
g ~ 9.81 m/s**2
任务
编写一个参数为v（以km / h为单位）的max_ball函数，该函数以设备记录的最大高度的十分之一秒为单位返回时间。

max_ball(15) should return 4

max_ball(25) should return 7
 */
public class Ball_Upwards {

    private static double h(int v0, int t0) {
        double v = v0 / 3.6;  // 转为m/s
        double t = t0 / 10.0;
        double g = 9.81;
        return v * t - 0.5 * g * t * t;
    }
    public static int maxBall(int v0) {
        double h0 = 0;
        double h1 = 0;
        int t0 = 0;
        while (h1 - h0 >= 0) {
            h1 = h(v0, t0);
//            System.out.printf("%f %f\n", h0, h1);
            if (h1 - h0 < 0) {
                break;
            } else {
                h0 = h1;
            }
            t0++;
        }
        return t0 - 1;
    }

    // 答案之一 思路不同 从数学角度出发 利用求导得到t=v/g时就是最大高度
    // height from ground, u is time in s, v speed in m/s
    private static double h(double u, double v, double g) {
        return v*u - 0.5*g*u*u;
    }
    public static int maxBall2(int v0) {
        // acceleration
        double g = 9.81;
        // from km/h to m/s
        double v = v0 * 1000 / 3600.0;
        // in: t = v/g the derivative is 0, the height is max
        double t = v / g;  // 达到最大高度时的秒数
        // record done every 0.1 s; tm is in tenth of second
        int tm = (int)Math.floor(t*10);  // 小于等于t*10的整数，tm就是第几个1/10秒
        // device max is before (<=) or after tm (>)
        double h1 = h( tm/10.0, v, g ), h2 = h( (tm+1)/10.0, v, g );
        double mx = Math.max( h1, h2 );  // 比较靠近哪个整是最大的
        // System.out.println("MAX_BALL tm ", tm, " tm+1 ", tm+1, " mx ", mx);
        // is the recorded max before or after the theoric max
        if (mx == h1) {
            return tm;
        } else {
            return tm+1;
        }
    }

    public static void main(String[] args) {
        int test = 99;
        System.out.println(maxBall(test));
//        System.out.println(h(test, 1));
    }
}
