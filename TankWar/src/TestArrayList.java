import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Anakinliu.
 * On 2016/11/5.
 */
public class TestArrayList {
    private ArrayList<String> test;
    /*
    1. ����һ��ArrayList������������Ӽ����ַ���������Ȼ�������б���������
Ҫ��ʹ�õ�������������ǿ��ѭ��������
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
