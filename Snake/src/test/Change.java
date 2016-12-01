package test;

/**
 * Created by liu_y.
 * On 2016/10/27.
 */
public class Change {
    public static void change(Integer x) {
        x =324324;
        System.out.println(x);
    }
    public static void main(String[] args) {
        Integer x = 9;
        change(x);
        System.out.println(x);

    }
}
