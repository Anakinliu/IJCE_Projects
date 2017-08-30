package HoldingObjects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Anakinliu on 2017/8/4.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class Ex9_Hold_List {
    List<String> item = new ArrayList<String>();
    private void add(String s) {
        item.add(s);
    }
    private Iterator iterator() {
        return item.iterator();
    }

    public static void main(String[] args) {
        Ex9_Hold_List ex9_hold_list = new Ex9_Hold_List();
        for (int i = 0;i < 10; i++) {
            ex9_hold_list.add(Integer.toString(i));
        }
        Iterator iterator = ex9_hold_list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
