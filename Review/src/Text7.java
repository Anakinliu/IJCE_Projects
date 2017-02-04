/**
 * Created by Anakinliu on 2017/1/6.
 *
 * 给出以下接口HelloWorld，请编写一个类MyHelloWorld实现该接口，并满足接口中所要求的功能。
 接口HelloWorld的代码如下：
 public interface HelloWorld {
 **
 *返回name + " say: hello world!".
 *
  String sayHelloWorld(String name);
          }
    */
interface HelloWorld {
    String sayHelloWorld(String name) ;
    /*
    接口所有方法全是抽象方法
    只能 public abstract修饰 （默认public abstract修饰 ），
    属性默认public static final修饰。
             抽象类除了包含抽象方法外与普通类无区别。
     */

}
public class Text7 implements HelloWorld{
    public String sayHelloWorld(String name) {
        return name + " sat: hello World !";
    }
}
