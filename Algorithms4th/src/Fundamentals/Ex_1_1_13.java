package Fundamentals;

/**
 * Created by Anakinliu on 17.11.20.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */

/*
   TODO 1.1.13 编写一段代码，打印出一个M 行N 列的二维数组的转置（交换行和列）。
 */
public class Ex_1_1_13 {
    private static int[][] x;
    private static void init() {
        x = new int[2][4];
        int number = 0;
        for (int i=0, j=0; i < x.length; i++) {
            for (j=0; j < x[0].length; j++) {
                x[i][j] = number++;
            }
        }
    }
    private  static void show() {
        for (int i=0, j=0; i < x.length; i++) {
            for (j=0; j < x[0].length; j++) {
                System.out.print(x[i][j] + "|");
            }
            System.out.println();
        }
    }

    /*
      打印转置矩阵
     */
    private static void transpose() {
        for (int i=0, j=0; i < x[0].length; i++) {
            for (j=0; j < x.length; j++) {
                System.out.print(x[j][i] + "|");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        init();
        show();
        transpose();
    }
}
