/**
 * Created by Anakinliu on 17.11.21.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class Ex_1_1_18 {
    /*
    结果竟然是 a x b!!!
     */
    private static int mystery(int a, int b) {
        if (b == 0)
            return 0;
        int y;
        if (b % 2 == 0) {
            y = mystery(a + a, b / 2);
            return y;
        }
        y = mystery(a + a, b / 2) + a;
        return y;
    }
    /*
    aa^bb
     */
    private static int mystery2(int aa, int bb) {
        if (bb == 0)
            return 1;
        int y;
        if (bb % 2 == 0) {
            y = mystery2(aa * aa, bb / 2);
            return y;
        }else {
            y = mystery2(aa * aa, bb / 2) * aa;
            return y;
        }
    }

    public static void main(String[] args) {
        System.out.println(mystery(2, 25));
        System.out.println(mystery(3, 55));
        System.out.println(mystery(3, 3));

        System.out.println(mystery2(3, 4));
        System.out.println(mystery2(3, 5));
    }
}
