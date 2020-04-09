package kyu5;

import java.util.ArrayList;

/*
    AUTHOR: linux
    TIME: 2020/4/9
    GOOD LUCK AND NO BUG.
*/
/*
https://www.codewars.com/kata/54f8693ea58bce689100065f/solutions/java

古埃及分数的贪婪算法求解

给定一个有理数 n，
将这个数字分解为分子等于1且无重复的有理数之和
（2/3 = 1/2 + 1/6是正确的，
但不是2/3 = 1/3 + 1/3，重复1/3，而且分母中，3比2大）
分解算法必须是贪婪的，要更小的分母

例如，
21/23分解结果为
"[1/2, 1/3, 1/13, 1/359, 1/644046]"
 */
public class Some_Egyptian_fractions {
    public static long GCD(long a, long b) {
        return a % b == 0 ? b : GCD(b, a % b);
    }

    public static long LCM(long a, long b) {
        return a * b / GCD(a, b);
    }

    public static String decompose(String nrStr, String drStr) {
        // your code
        ArrayList<String> res = new ArrayList<>();
//        System.out.println(nrStr + "/" + drStr);
        long fz = Integer.parseInt(nrStr);
        long fm = Integer.parseInt(drStr);
        if (fz == 0) {
            return res.toString();
        }
        if (fz % fm == 0) {
            res.add(String.valueOf(fz / fm));
            return res.toString();
        }
        if (fz > fm) {
            res.add(String.valueOf(fz / fm));
            fz = fz % fm;
        }
//        System.out.println(fm / 2);  // 整数，下取整
        long y = GCD(fz, fm);  // 最大公约数
        fz /= y;
        fm /= y;
        System.out.println(fz + "/" + fm);
        long z;
        while (fz != 1) {
            z = fm / fz + 1;
            res.add("1/" + z);
            long b = LCM(fm, z);
            fz = (b / fm) * fz - (b / z);
            fm = b;
            y = GCD(fz, fm);  // 最大公约数
            fz /= y;
            fm /= y;
            System.out.println(fz + "/" + fm);
        }
        res.add("1/" + fm);
        return res.toString();
    }

    // 和我一开始写的类似， 这里使用分子乘，而非分母除，避免了出现很小的数，妙啊
    public static String decompose2(String nrStr, String drStr) {
        long a = Integer.parseInt(nrStr);
        long b = Integer.parseInt(drStr);
        long denum = 2;
        String s;
        if (a>b){
            s = ", "+a/b;
            a %= b;
        } else s = "";
        while(a>0){
            if (a*denum>=b){
                s += ", 1/"+denum;
                a = a*denum-b;
                b *= denum;
            }
            denum++;
        }
        return s.isEmpty()?"[]":"["+s.substring(2)+"]";
    }
    public static void main(String[] args) {
        System.out.println(decompose("50", "4187"));
//        System.out.println(decompose("21", "23"));
//        System.out.println(decompose("19", "20"));
//        System.out.println(decompose("9", "10"));
    }
}
