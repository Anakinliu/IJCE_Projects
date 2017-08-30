package String;

/**
 * Created by Anakinliu on 2017/5/23.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class InfiniteRecursion {
    public static String implicit (String[] fields) {
        String result = "";
        for (int i = 0; i < fields.length; i ++) {
            result += fields[i];
        }
        return result;
    }

    public static String explicit (String[] fields) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            result.append(fields[i]);
        }
        return result.toString();
    }

    public String toString() {
        return this + "";
    }
    public static void main(String[] args) {
        String[] strings = {"hate", "zz"};
        implicit(strings);
        explicit(strings);
        System.out.println(new InfiniteRecursion());
    }
}
