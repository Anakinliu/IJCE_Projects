package kyu6;

/*
    AUTHOR: linux
    TIME: 2020/2/28
    GOOD LUCK AND NO BUG.
*/
/*
从高度 h 向下抛球，反弹到 h * bounce 高度，接着反弹。。。
window是窗户高度，假设窗户本身高度无穷小，计算球经过window的次数。

Float parameter "h" in meters must be greater than 0
Float parameter "bounce" must be greater than 0 and less than 1
Float parameter "window" must be less than h.
 */
public class Bouncing_Balls {
    public static int bouncingBall(double h, double bounce, double window) {
        // your code
        if (h < 0.0 || bounce <= 0 || bounce >= 1 || window >= h) {
            return -1;
        }
        int count = 1;
        h = h * bounce;
        while (h > window) {
            count += 2;
            h = h * bounce;
        }
        return count;
    }

    // 答案之一 数学方式 对数函数 换底
    public static int bouncingBall2(double h, double bounce, double window) {
        if (h > 0 && 0 < bounce && bounce < 1 && window < h)
            return 1 + 2 * (int) Math.floor(Math.log(window / h) / Math.log(bounce));
        else
            return -1;
    }

    public static void main(String[] args) {
        System.out.println(bouncingBall2(3.0, 0.66, 1.5));
    }
}
