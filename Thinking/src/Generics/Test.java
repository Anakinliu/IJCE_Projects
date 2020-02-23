package Generics;

/*
    AUTHOR: linux
    TIME: 2018/5/12
    GOOD LUCK AND NO BUG.
*/

/*
TODO 公众号: 码农每日一题
TODO https://mp.weixin.qq.com/s?__biz=MzI3ODc3NzQ4NQ==&mid=2247483907&idx=1&sn=0d6ea35f46d502a70b008224d0413f71&chksm=eb5099e1dc2710f75e1579e130cfaf4f802e6e6cfa652ba938cc562ba10874ab4c6c9181ceb1&scene=21#wechat_redirect
 */
/*
<T extends E> 和 <? extends E> 有什么区别？
 */
import java.util.ArrayList;
import java.util.List;

class Bean <E> {
    public Bean(List<? extends E> list) {

    }

}
public class Test {
    /*
    说说 <T extends E> 和 <? extends E> 有什么区别？
     */

    /*
    <? extends E> 用于实例化类型参数，
    用于实例化泛型变量中的类型参数，
    只是这个具体类型是未知的，只知道它是 E 或 E 的某个子类型。
     */
    public static void addAll(Bean<? extends Number> bean) { }

    /*
    <T extends E> 用于定义类型参数，
    声明了一个类型参数 T，
    这里把它放到了泛型方法返回值(void)前面。
     */
    public static  <T extends Number> void addAll2(Bean<T> bean) { }

    public static void main(String[] args) {
        //TODO <T extends E> 和 <? extends E>两种写法经常可以达到相同的目的
        addAll(new Bean<Number>(new ArrayList<Integer>()));
        addAll2(new Bean<Number>(new ArrayList<Integer>()));


        /*
        简单说说 List<Object> 与 List<?> 类型之间的区别？
         */
        /*
        List<?> 是一个未知类型的 List，
        而 List<Object> 其实是任意类型的 List，
        我们可以把 List<String>、List<Integer> 赋值给 List<?>，
        却不能把 List<String> 赋值给 List<Object>。譬如：
         */
        List<?> listOfAnyType;
        List<Object> listOfObject = new ArrayList<>();
        List<String> listOfString = new ArrayList<>();
        List<Integer> listOfInteger = new ArrayList<>();
        listOfAnyType = listOfInteger;
        listOfAnyType = listOfString;
        listOfAnyType = listOfObject;

        // Error:(63, 24) java: 不兼容的类型: java.util.List<capture#1, 共 ?>无法转换为java.util.List<java.lang.Object>
//        listOfObject = listOfAnyType;
//
//        listOfObject = listOfString;


    }
}
