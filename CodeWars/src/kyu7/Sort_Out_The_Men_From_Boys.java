package kyu7;

import java.util.*;

/*
    AUTHOR: linux
    TIME: 2020/2/23
    GOOD LUCK AND NO BUG.
*/
/*
从一个数组中挑出偶数，偶数在前
偶数升序，奇数降序，可能是最大/小的数
结果数组中重复的数要丢弃
给定的数输入组不包含0

menFromBoys ({7, 3 , 14 , 17}) ==> return ({14, 17, 7, 3})
 */
public class Sort_Out_The_Men_From_Boys {
    public static int[] menFromBoys(final int[] values) {
        // Your Code is Here .. Enjoy !! , Don't Forget To Vote :wink: :wink
        HashSet<Integer> evenSet = new HashSet<>();
        HashSet<Integer> oddSet = new HashSet<>();
        for (int e : values) {
            if (e % 2 == 0) {
                evenSet.add(e);
            } else {
                oddSet.add(e);
            }
        }
        // Set保证不重复但是不保证顺序
        List<Integer> oddList = new ArrayList<>(oddSet);
        Collections.sort(oddList, Collections.reverseOrder());  // 排序

        List<Integer> evenList = new ArrayList<>(evenSet);
        Collections.sort(evenList);  // 排序

        evenList.addAll(oddList);

        return Arrays.stream(evenList.toArray()).mapToInt(x ->  (int)x).toArray();
    }

    // 又是stream大神
    public static int[] menFromBoys2(final int[] values) {
        return Arrays.stream(values)
                .distinct()
                .boxed()
                .sorted(Comparator.comparing(i -> i % 2 == 0 ? i : -i))
                .sorted(Comparator.comparing(i -> Math.abs(i % 2)))
                .mapToInt(i -> i)
                .toArray();
    }

    // 算法大神
    public static int[] menFromBoys3(final int[] values) {
        int[] result;
        Set<Integer> evenSet = new TreeSet<>();
        Set<Integer> oddSet = new TreeSet<>();

        for (int value : values) {
            if (value % 2 == 0) {
                evenSet.add(value);
            } else {
                oddSet.add(value);
            }
        }
        List<Integer> list = new ArrayList<>(oddSet);
        Collections.reverse(list);
        result = new int[evenSet.size() + oddSet.size()];
        int counter = 0;

        for (Integer elem : evenSet) {
            result[counter++] = elem;
        }

        for(Integer elem : list) {
            result[counter++] = elem;
        }

        return result;
    }

    public static void main(String[] args) {
//        System.out.println(-6 % 2);
        int[] test = new int[]{2,15,17,15,2,10,10,17,1,1};
        System.out.println(Arrays.toString(menFromBoys(test)));
    }
}
