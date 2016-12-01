/**
 * Created by Anakinliu.
 * On 2016/11/8.
 */
public class EctendClass extends SuperClass {
    public void what() {
        System.out.println("EctendClassClass what()");
    }
    public static void main(String[] args) {
        SuperClass sc = new EctendClass();
        sc.show();
    }
}
