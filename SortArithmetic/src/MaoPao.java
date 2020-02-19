import java.util.Arrays;

/*
    AUTHOR: linux
    TIME: 2020/1/4
    GOOD LUCK AND NO BUG.
*/
public class MaoPao {
    public static void sort(int[] arr) {
        // 大到小
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            // j从0开始哦
            for (int j = size-1; j > i; j--) {
                // 改为<就是小到大
                if (arr[j] > arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(ARRAY.arr));
        sort(ARRAY.arr);
        System.out.println(Arrays.toString(ARRAY.arr));
    }
}
