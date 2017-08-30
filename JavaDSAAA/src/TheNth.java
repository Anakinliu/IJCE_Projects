import java.util.Scanner;

/**
 * Created by Anakinliu on 2017/4/19.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class TheNth {
    private  int[] compare;
    private int nTh;
    private  int firstIndex = 0;
    private String[] inputA;

    TheNth(int nTh) {
        this.nTh = nTh;
        compare = new int[nTh];
    }

    private  void getInput(String input) {
        inputA = input.split("\\D* \\b\\D*");
        getPartInput();
    }

    private  void getPartInput() {
        int i = 0;
        for (String s : inputA) {
            compare[i++] = Integer.parseInt(s);
            if (i == nTh) {
                break;
            }
        }
        sortThePart();
    }

    /*
    递减排序
     */
    private void sortThePart() {
       for (int i=0; i<nTh; i++) {
           for (int j=i+1; j<nTh-i; j++) {
               if (compare[i] < compare[j]) {
                   int temp = compare[i];
                   compare[i] = compare[j];
                   compare[j] = temp;
               }
           }
       }
    }

    /*作用:
    得到第n大的数
     */

    public  int getNth(int nIndex) {
        // 用来保存前n个的数
        int[] nl = new int[nIndex];
        // 将前n个数按照递减的顺序保存到nl数组
        for (int i=0; i<nIndex; i++) {
            int temp = compare[i];
            for (int j=i + 1; j<nIndex; j++) {
                if (temp < compare[j]) {
                    temp = compare[j];
                }
            }
            nl[i] = temp;
        }
        return nl[nIndex - 1];
    }

    public static void main(String[] args) {

        Scanner scanner  = new Scanner(System.in);
        String input = scanner.nextLine();
        TheNth nTh = new TheNth(5);
        nTh.getInput(input);
    }
}
