/**
 * Created by Anakinliu.
 * On 2016/11/8.
 */
public class TestInteger {
    public static void main(String[] args) {
        Integer x = 2;
        Integer y = 2;
        Integer xx = new Integer(3);
        Integer yy = new Integer(3);
        System.out.println(x == y);
        System.out.println(xx == yy);
        System.out.println(xx.equals(yy));
    }
}
