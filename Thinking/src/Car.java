/**
 * Created by liu_y.
 * On 2016/10/27.
 */

//-----------7.5---------------
//在组合与继承之间选择

class Engine {
    public void start() {}
    public void rev() {}
    public void stop() {}
    public void service() {}
}

class Whell {
    public void inflate(int psi) {}
}

class Window {
    public void rollUp() {};
    public void rollDown() {};
}

class Door {
    public Window window = new Window();
    public void open(){}
    public void close() {}
}



public class Car {
    public Engine engine = new Engine();
    public Whell[] whell = new Whell[4];
    public Door
        left = new Door(),
        right = new Door();
    public Car() {
        for (int i=0; i<4; i++) {
            whell[i] = new Whell();
        }
    }
    public static void main(String[] args) {
        Car c = new Car();
        c.left.window.rollUp();
        c.whell[0].inflate(78);
        c.engine.service();
    }
}
