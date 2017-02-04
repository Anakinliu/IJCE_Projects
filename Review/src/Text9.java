import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anakinliu on 2017/1/8.
 */

interface IList {
    /**
     * 往列表尾部增加一个元素
     */
    void add (Object o) ;

    /**
     * 获取下表指定的元素，当下标越界时抛出异常
     */

    Object get (int i);

    /**
     * 获取当前列表的个数
     */
    int size();

    /**
     * 移除列表的所有元素
     */
    void clear();
}
class MyList implements IList{

    private ArrayList<Object> list;

    public MyList () {
        list = new ArrayList();
    }

    @Override
    public void add(Object o) {
        list.add(o);
    }

    @Override
    public Object get(int i) {
        return list.get(i);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void clear() {
        list.clear();
    }
}
public class Text9 {
    static MyList myList = new MyList();

    public static void main(String[] args) {
        myList.add(7);
        myList.get(3);
    }
}