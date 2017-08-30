package ClassDetails;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Anakinliu on 2017/7/18.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
abstract class Shape {
    // this转换成字符串时会调用toString方法
    void draw() { System.out.println(this + ".draw()"); }
    abstract public String toString();
    void rotate() {
        if (this instanceof Circle ) {
            System.out.println("Circle needn't rotate!");
        }
        System.out.println(this + "Rotating!");
    }
}

class Circle extends Shape {
    public String toString() { return "Circle"; }
}

class Square extends Shape {
    public String toString() { return "Square"; }
}

class Triangle extends Shape {
    static int static_i = 9;
    int nor_i = 6;
    public String toString() { return "Triangle"; }
}

class Rhomboid extends Shape {
    public String toString() { return "Rhomboid"; }
}

public class Shapes4 {
    public static void main(String[] args) {
        // upcasting to Shape:
        List<Shape> shapeList = Arrays.asList(
                new Circle(), new Square(), new Triangle(), new Rhomboid()
        );
        // downcasting back to specific shape:
        for(Shape shape : shapeList) {
            shape.draw();
            shape.rotate();
        }
        Rhomboid r = new Rhomboid();
        // Upcast:
        Shape s = (Shape)r;
        s.draw();
        // check type before downcast:
        if(s instanceof Circle)
            ((Circle)s).draw();
        else
            System.out.println("(Shape)r is not a Circle");
    }
}
