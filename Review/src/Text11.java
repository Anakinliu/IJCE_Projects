import java.util.HashMap;

/**
 * Created by Anakinliu on 2017/1/8.
 */
public class Text11 {
    private static HashMap hashMap;
    public Text11() {
        hashMap = new HashMap();

        hashMap.put("张三",8000);
        hashMap.put("李四",6000);
    }

    public static void show() {
        System.out.println(hashMap.get("张三"));
        System.out.println(hashMap.get("李四"));
    }

    public void change() {
        System.out.println("changed");
        hashMap.put("张三",9000);
        //在此映射中关联指定值与指定键。
        // 如果该映射以前包含了一个该键的映射关系，
        // 则旧值被替换。
    }

    public static void main(String[] args) {
        Text11 t = new Text11();
        t.show();
        t.change();
        t.show();
    }

}
