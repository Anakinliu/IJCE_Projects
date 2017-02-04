import java.util.Objects;

/**
 * Created by Anakinliu on 2017/1/6.
 */
class Been {
    @Override
    public String toString() {
        return "Been{}";
    }
}
class ChildBeen extends Been  {
    @Override
    public String toString() {
        return "ChildBeen{}";
    }
}
public class TestT<T> {
    private T x,y,z;
    public TestT (T x, T y, T z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }

    public T getZ() {
        return z;
    }

    public void setZ(T z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "TestT{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    public static void main(String[] args) {
        TestT<Been> test = new TestT<Been>(new ChildBeen(),new ChildBeen(), new Been());
        System.out.println(test);
    }
}

