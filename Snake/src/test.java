import java.util.ArrayList;

/**
 * Created by Anakinliu.
 * On 2016/11/13.
 */

public class test {
    private ArrayList<Object> x = new ArrayList<Object>();

    public ArrayList<Object> getX() {
        return x;
    }

    public void setX(ArrayList<Object> x) {
        this.x = x;
    }

    public void add(Object elem) {
        getX().add(elem);
    }
    public Object get(int index) {
        return getX().get(index);
    }
    public int size() {
        return getX().size();
    }
    public void clear() {
        getX().clear();
    }
    public  void s(int s) {

    }

    public static void main(String[] args) {
        test t1 = new test();
        t1.add(2);
        long n1 = 0b11011_01;
        float n2 = 0_1_2_3;
        String text = "Welcome to Java contest";
        String[] words = text.split("");
        System.out.println(t1.size());

    }
}
