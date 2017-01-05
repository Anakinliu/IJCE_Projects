import java.util.*;

/**
 * Created by Anakinliu.
 * On 2016/11/17.
 */
public class TestCollection {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        System.out.println(c.getClass());
        c = new HashSet();
        System.out.println(c.getClass());
        c.add(new String("liu"));
        c.add(new String("liu"));
        System.out.println(c.size());
    }
}
