/**
 * Created by Anakinliu on 2017/4/19.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class Recursive {
    public static int f(int x) {
        if (x == 0) {
            return 0;
        }
        else
            return 2 * f(x - 1) + x * x;
    }

    public static void main(String[] args) {
        
    }
}
