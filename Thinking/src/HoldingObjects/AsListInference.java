package HoldingObjects;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Anakinliu on 2017/8/2.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
class Snow {

}
class Power extends Snow {

}
class Light extends Power {

}
class Heavy extends Power {

}
public class AsListInference {
    public static void main(String[] args) {
        // JDK5/6 无法通过编译
        List<Snow> snow2 = Arrays.asList(new Light(), new Heavy());
        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add(null);
        hashSet.add(null);
        hashSet.add("s");
        hashSet.add("s");
        System.out.println(hashSet);
    }
}
