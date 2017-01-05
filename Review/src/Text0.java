/**
 * Created by Anakinliu on 2016/12/29.
 */
public class Text0 {
    public static void main(String[] args) {
        double sum = 0;
        for (int i=1;i<=20;i++) {
            sum = sum + Math.pow(2,i) - 1.0;
        }
        System.out.println("sum=" + sum);
    }
}
