package InnerClass;

/**
 * Created by Anakinliu on 2017/2/6.
 * GO! GO! GO!
 */
interface Pratice {
    void show () ;
}
public class Pratice9 {

    //方法返回对此接口的引用
    public Pratice getPratice() {
        //方法内部的类实现Pratice接口
        class Me implements Pratice {
            @Override
            public void show() {

            }
        }

        //返回实现类的对象
        return new Me();
    }
}
