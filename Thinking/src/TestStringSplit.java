/**
 * Created by Anakinliu.
 * On 2016/11/8.
 */
public class TestStringSplit {
    public static void main(String[] args) {
        String s = "liu,yin,quan";
        String[] x = s.split(",");
        for (String ss:x)
        System.out.println(ss);
    }
}
