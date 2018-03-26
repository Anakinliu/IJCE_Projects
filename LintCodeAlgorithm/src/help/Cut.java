package help;

/**
 * Author: Anakinliu
 * Date: 2018/03/26
 * Time: 14:36
 * You may be disappointed if you fail,
 * but you are doomed if you don't try.
 */
/*
算法砖头的动态规划的例题
每段价格固定, 给定一个长段, 求解如何切割得最大值, 切割为几段不限
 */
public class Cut {
    public static final int[] prices
            = new int[]{-999, 10, 5, 8, 9, 10, 17, 17, 20, 24, 30};

    public static int cut(int n) {
        if (n == 0) {
            return 0;
        }
        int a = -1;
        int i = 1;
        for (; i <=n; i++) {
            a = Math.max(a, prices[i] + cut(n - i));
        }
        return a;
    }

    public static int menoizedCut(int n, int[] meno) {
        if (meno[n] >= 0) {
            return meno[n];
        }
        int q = -1;
        if (n == 0) {
            q = 0;
        } else {
            for (int i = 1; i <= n; i++) {
                q = Math.max(q, prices[i] + menoizedCut(n - i, meno));
            }
        }
        meno[n] = q;
        return q;
    }

//    public static int buttomUpCut(int n) {
//
//    }

    public static void main(String[] args) {
        System.out.println(cut(4));
//        int[] meno = new int[]{-1, -1, -1, -1, -1, -1};
//        System.out.println(menoizedCut(5, meno));
    }
}
