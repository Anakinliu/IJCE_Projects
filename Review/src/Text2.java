/**
 * Created by Anakinliu on 2016/12/29.
 */
public class Text2 {
    public static boolean is(int n) {
        if (n <= 1) {
            return false;
        }
        else {
            int i;
            for (i = 2; i <= n-1; i++) {
                if (n % i == 0) {
                    break;
                }
            }
            if (i == n) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 2; i++) {
            if (is(i)) {
                sum = sum + i;
            }
        }
        System.out.println("sum=" + sum);
    }
}
