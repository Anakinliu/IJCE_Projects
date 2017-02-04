import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anakinliu on 2017/1/6.
 * 给出如下Shape类，请定义一个公有类Rectangle,满足以下要求：
 1.	继承于Shape，实现Shape的所规定的功能
 2.有int类型的width和height属性（宽和高）及相应的getter和setter
 3.有一个带两个int参数的共有构造方法，第一个参数用于设置宽，第二个参数用于设置高
 public abstract class Shape {
 **
 *计算形状的面积
 *
 *abstract public int getArea();
 *       }
 *
 */
abstract class Shape {
    public abstract int getArea();
}
public class Text8 extends Shape{

    private int w;
    private int h;

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public Text8(int w, int h) {
        this.w = w;
        this.h = h;
    }

    @Override
    public int getArea() {
        return w * h;
    }

    public static void main(String[] args) {

    }
}
