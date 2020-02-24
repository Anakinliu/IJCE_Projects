package 补充;

/*
    AUTHOR: linux
    TIME: 2020/2/24
    GOOD LUCK AND NO BUG.
*/
interface MM {
    // 默认public static final
    String sex = "mm";
}
public class Interface_Demo implements MM{
    public static void main(String[] args) {
        Interface_Demo demo = new Interface_Demo();
        // 使用instanceof接口
        System.out.println(demo instanceof MM);
    }
}
