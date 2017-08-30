package InnerClass;

/**
 * Created by Anakinliu on 2017/2/6.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
abstract class Wrapping {
    private int x = 47;
    public Wrapping(int x) {
        this.x = x;
    }
    public int value() {
        return x;
    }
}


//问：匿名内部类  的  基类构造器  有参数 怎么办
public class Parcel8 {
    public Wrapping wrapping(int x) {

        //调用基类构造器
        return new Wrapping(x) {    //为构造器传入参数
            public int value() {
                return super.value() * 47 * x;
            }
        };  //注意分号！！！

    }

    //答：只需简单地传入参数即可

    public static void main(String[] args) {
        Parcel8 p = new Parcel8();
        Wrapping wrapping =  p.wrapping(47);
    }
}
