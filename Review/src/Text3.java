/**
 * Created by Anakinliu on 2016/12/29.
 */
//打印杨辉三角形
public class Text3 {
    int arr[][];

    Text3(int n) {
        //n是行数
        arr = new int[n][];
        int j,i;
        for (i=0; i<n; i++) {
            arr[i] = new int[i+1];
            arr[i][0] = 1;
            for (j=1; j<i; j++) {
                arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
            }
            if (j == i)
            arr[i][j] = 1;
        }
    }

    public void print() {
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Text3 s = new Text3(9);
        s.print();
    }
}
