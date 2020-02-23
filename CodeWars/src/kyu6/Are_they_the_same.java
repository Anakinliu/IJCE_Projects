package kyu6;

import java.util.Arrays;
import java.util.HashMap;

/*
    AUTHOR: linux
    TIME: 2020/2/20
    GOOD LUCK AND NO BUG.
*/
/*
数组 b 中所有元素都由数组 a 中元素平方得到
a或b可能是[]（R，Shell以外的所有语言）。
a或b可能为nil或null或无或无（Haskell，Elixir，C ++，Rust，R，Shell，PureScript中除外）。
如果a或b为nil（或null或None），则该问题没有意义，因此返回false。
如果a或b为空，则结果不言而喻。

注意！
若
a = [2, 2, 3]
b = [4, 4, 9]
则合法
若
a = [2, 2, 3]
b = [4, 9, 9]
则不合法，虽然长度相同，但是a的第二个2在b中没有对应的4，b的第二个9在a中没有对应的3 ！！！

 */
public class Are_they_the_same {
    public static boolean comp(int[] a, int[] b) {
        if (null == a || null == b) {
            return false;
        }
        int aL = a.length;
        int bL = b.length;
        if (aL == 0 && bL == 0) {
            return true;
        }
        if (aL == 0) {
            return false;
        }
        if (bL == 0) {
            return false;
        }
        if (aL != bL) {
            System.out.println("not same");
            return false;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int k : a) {
            int power = k * k;
            if (hashMap.containsKey(power)) {
                int count = hashMap.get(power);
                System.out.println(count);
                hashMap.put(power, count + 1);
            } else {
                hashMap.put(power, 1);
            }
        }
        System.out.println(Arrays.toString(hashMap.keySet().toArray()));
        System.out.println(Arrays.toString(hashMap.values().toArray()));

        for (int i : b) {
            if (hashMap.containsKey(i)) {
                int count = hashMap.get(i);
                hashMap.put(i, count - 1);
            } else {
                return false;
            }
        }
        System.out.println(Arrays.toString(hashMap.keySet().toArray()));
        System.out.println(Arrays.toString(hashMap.values().toArray()));

        for (int v : hashMap.values()) {
            if (v >= 1) {
                System.out.println("here");
                return false;
            }
        }
        return true;
    }

    // 出题人写法  又是管道stream。。。看来是个神器了
    public static boolean comp2(int[] a, int[] b) {
        if ((a == null) || (b == null)){
            return false;
        }
        int[] aa = Arrays.stream(a).map(n -> n * n).toArray();
        Arrays.sort(aa);
        Arrays.sort(b);
        return (Arrays.equals(aa, b));

    }
    public static void main(String[] args) {
        int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
        int[] b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361};
        System.out.println(comp2(a, b));
        int[] c = new int[]{2, 2, 9};
        int[] d = new int[]{4, 9, 9};
        System.out.println(comp2(c, d));

    }

}
