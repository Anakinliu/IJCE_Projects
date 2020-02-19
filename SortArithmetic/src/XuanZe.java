import java.util.Arrays;

/*
    AUTHOR: linux
    TIME: 2020/1/4
    GOOD LUCK AND NO BUG.
*/
public class XuanZe {
    public static void sort(int arr[]) {
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            int index = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            if (index != i) {
                // arr[i]本身就是最小的
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }

        }
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(ARRAY.arr));
        sort(ARRAY.arr);
        System.out.println(Arrays.toString(ARRAY.arr));
    }
}
