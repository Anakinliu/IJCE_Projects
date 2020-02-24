package kyu6;

/*
    AUTHOR: linux
    TIME: 2020/2/24
    GOOD LUCK AND NO BUG.
*/
/*
john存钱f0到银行与第一年，
银行利率p每年，多年不变
每年取c0，任意时刻可取，需要考虑 i 通货膨胀，i 也是多年不变
所有金额f0..fn-1，c0..cn-1被银行截断至其整数部分

给定f0，p，c0，银行保证约翰将能够继续这样做直到第 n 年。

举例
f0 = 100000, p = 1 percent, c0 = 2000, n = 15, i = 1 percent

beginning of year 2 -> f1 = 100000 + 0.01*100000 - 2000 = 99000;  c1 = c0 + c0*0.01 = 2020 (with inflation of previous year)

beginning of year 3 -> f2 =  99000 + 0.01*99000 - 2020  = 97970;  c2 = c1 + c1*0.01 = 2040.20
(with inflation of previous year, truncated to 2040)
 */
public class Bankers_Plan {
    public static boolean fortune(int f0, double p, int c0, int n, double i) {
        // your code
        int cn = c0;
        int fn = f0;
        int years = 0;
        while (fn >= 0) {
            fn = fn + (int) (p * fn * 0.01) - cn;
            cn = cn + (int) (i * cn * 0.01);
            years++;
//            System.out.println(fn);
//            System.out.println(cn);
//            System.out.println();
        }
        System.out.println(years);
        return years >= n;
    }

    public static void main(String[] args) {
        System.out.println(fortune(100000000, 5, 1000000, 50, 1));
    }
}
