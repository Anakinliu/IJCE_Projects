import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Anakinliu.
 * On 2016/11/5.
 */
public class TestArrayList {
    private ArrayList<String> test;
    /*
    1. 创建一个ArrayList对象，在其中添加几个字符串常量，然后对其进行遍历操作。
要求：使用迭代器遍历和增强型循环遍历。
     */
    public TestArrayList() {
        test = new ArrayList<String>();
    }
    public ArrayList<String> getTest() {
        return test;
    }

    public void setTest(ArrayList<String> test) {
        this.test = test;
    }

    public void showIterator() {
        System.out.println("------ Iterator ------");
        for (Iterator<String> i = getTest().iterator();i.hasNext();) {
            String s = i.next();
            System.out.println(s);
        }
    }

    public void showForeach() {
        System.out.println("------ Foreach ------");
        for (String s : getTest()) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        TestArrayList t = new TestArrayList();
        t.getTest().add("first e");
        t.getTest().add("second e");
        t.getTest().add("third e");
        t.showIterator();
        t.showForeach();
    }
}
