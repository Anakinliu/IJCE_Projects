package kyu6;

import java.util.ArrayList;

/*
    AUTHOR: linux
    TIME: 2020/2/25
    GOOD LUCK AND NO BUG.
*/
public class A_Rule_of_Divisibility_by_13 {

    public static ArrayList<Integer> getDigits(long n) {
        // 分出各个位的数字
        ArrayList<Integer> digitsList = new ArrayList<>();
        while (n / 10 > 0) {
            digitsList.add((int)(n % 10));
            n = n / 10;
        }
        digitsList.add((int)(n));
        return digitsList;
    }

    public static long thirt(long n) {
        // your code
        int[] cons = new int[]{1, 10, 9, 12, 3, 4};
        int consIndex = 0;

        ArrayList<Integer> digitsList = getDigits(n);

        ArrayList<Long> resultsList = new ArrayList<>();

        long result = 0;
        while (true) {
            // 每次都要归零
            consIndex = 0;
            result = 0;

//            System.out.println("s");
//            resultsList.add(result);
            // 计算一次
            for (Integer e : digitsList) {
                result += (long)e * (long)cons[consIndex];
                consIndex++;
                if (consIndex >= 6) {
                    consIndex = 0;
                }
            }
//            System.out.println(result);
            if (resultsList.contains(result)) {
                break;
            }
            resultsList.add(result);
            digitsList = getDigits(result);
//            System.out.println(digitsList);
//            System.out.println(resultsList);
//            System.out.println("e");
        }

//        System.out.println(Arrays.toString(digitsList.toArray()));
        return result;
    }


    // ------------大神的答案↓
    private static final int[] seq = new int[]{1,10,9,12,3,4};

    public static long thirt2(long n) {

        long v = 0, m = n;
        int p = 0;
        while (m>0) {
            v += (m%10)*seq[p++%6];
            m /= 10;
        }
        return v == n ? v : thirt2(v);

    }
    // 递归！
    public static long thirt3(long n) {
        // New number
        long r = 0;
        //Converting long to String
        String s = new String("" + n);
        for (int i = s.length()-1; i >=0 ; --i)
            r += (s.charAt(i) - '0') * seq[(s.length() - i - 1) % 6];
        if (r == n)
            return r;
        return thirt3(r);
    }
    // ------------大神的答案 ↑
    public static void main(String[] args) {
        long test = 1234567;
        System.out.println(thirt(test));
    }
}
