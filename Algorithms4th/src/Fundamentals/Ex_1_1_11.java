package Fundamentals;

/**
 * Created by Anakinliu on 17.10.28.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class Ex_1_1_11 {
    /**
     * 编写一段代码，打印出一个二维布尔数组的内容。其中，使用* 表示真，空格表示假。打印出
     行号和列号
     */
    private static void show(boolean[][] a) {
        System.out.println(a.length);
        System.out.println(a[0].length);
        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j]) {
                    System.out.print("r" + i + "," + "c" + j + " :*| " );
                }
                else {
                    System.out.print("r" + i + "," + "c" + j + " : | " );
                }
            }
            System.out.println();
        }
    }
    /*
    元素是true还是false的概率相等
     */
    private static void initArray(boolean[][] a) {
        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] = Math.random() > 0.5;
            }
        }
    }
    public static void main(String[] args) {
        boolean[][] a = new boolean[2][5];
        initArray(a);
        show(a);
    }
}
