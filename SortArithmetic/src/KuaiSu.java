import java.util.Arrays;

/*
    AUTHOR: linux
    TIME: 2020/1/4
    GOOD LUCK AND NO BUG.
*/
public class KuaiSu {
    public static void sort(int arr[], int left, int right) {
        if (left < right) {
            int i = left, j = right, target = arr[left];
            while (i < j) {
                while (i < j && arr[j] > target)
                    j--;
                if (i < j)
                    arr[i++] = arr[j];
                while (i < j && arr[i] < target)
                    i++;
                if (i < j)
                    arr[j] = arr[i];
            }
            arr[i] = target;
            sort(arr, left, i - 1);
            sort(arr, i + 1, right);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(ARRAY.arr));
        sort(ARRAY.arr, 0, ARRAY.arr.length - 1);
        System.out.println(Arrays.toString(ARRAY.arr));
    }
}
