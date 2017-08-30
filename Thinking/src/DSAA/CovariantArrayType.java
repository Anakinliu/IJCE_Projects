package DSAA;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Anakinliu on 2017/4/21.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
interface T {

}
// TODO : https://www.anakinliu.tech/note/58faa34b89c1e73678000004
abstract class Shape implements Comparable {

    @Override
    public int compareTo(@NotNull Object o) {
        if (o.equals(this) ) {
            return 0;
        } else {
            if (((Shape) o).area() < area()) {
                return 1;
            }
            if (((Shape) o).area() == area()) {
                return 0;
            }
            if (((Shape) o).area() > area()) {
                return -1;
            }
        }
        return -1;
    }

    public abstract double area();
}
class Circle extends Shape implements T {

    private double r;

    Circle(double r) {
        this.r = r;
    }

    public double area() {
        return Math.PI * r * r;
    }


}
class Rectangle extends Shape {
    private double a, b;

    Rectangle() {}

    Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double area() {
        return a * b;
    }

}
class GoodRectangle extends Rectangle {

    GoodRectangle(double a, double b) {
        super(a, b);
    }
}

public class CovariantArrayType {
    public static Comparable findMax(Comparable []arr) {
        int maxIndex = 0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i].compareTo(arr[maxIndex]) > 0)
                maxIndex = i;
        }

        return arr[maxIndex];
    }

    public static double totalAera(Collection<? extends Shape> arr) {
        double total = 0;
       // !  arr.add(new Circle(2));
        for (Shape s : arr) {
            total += s.area();
        }

        return total;
    }

    public static void changeShape(Collection<? super Shape> shapes) {
        shapes.add(new Circle(200));
    }


    public static void main(String[] args) {
        // TODO : https://www.anakinliu.tech/note/58faa34b89c1e73678000004

        Shape[] sh = {
                new Circle(1),
                new Rectangle(2, 2)
        };

        ArrayList<Shape> Shapes = new ArrayList<>();
        Shapes.add(new Rectangle(2,3));
        Shapes.add(new GoodRectangle(2, 3));
        Shapes.add(new Circle(3));
        changeShape(Shapes);
            System.out.println(totalAera(Shapes));

        ArrayList<Rectangle> rectangle = new ArrayList<>();
        totalAera(rectangle);

            System.out.println(findMax(sh));

        String a = "a";
        String A = a.toUpperCase();
        for (Class ss : Circle.class.getInterfaces())
            System.out.println(ss.getSimpleName());

            // !System.out.println(T.class.newInstance());

    }
}
