package Sort;

import edu.princeton.cs.algs4.In;

import java.util.Arrays;

/*
    AUTHOR: linux
    TIME: 2018/5/18
    GOOD LUCK AND NO BUG.
*/
public class SelectionSort extends Example{
    public void sort(Comparable[] comparables) {

        int length = comparables.length;
        for (int i = 0; i < length; i++) {
            // 从第一个元素开始, 遍历一遍数组, 寻找最小的, 遍历到最后, 将最小值与其交换
            int min = i;
            for (int j = i+1; j < length; j++) {
                // 2018/5/18 23:11--注意less的两个参数顺序...
                if (less(comparables[j], comparables[min])) {
                    min = j;
                }
            }
//            System.out.println(comparables[min]);
            showWithGraphic(comparables, -1, -1);
            exch(comparables, i, min);
        }
    }

    public static void main(String[] args) {


        new SelectionSort().sort(data);

        show(data);

    }
}
