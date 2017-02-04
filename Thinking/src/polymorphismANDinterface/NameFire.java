package polymorphismANDinterface;

/**
 * Created by Anakinliu on 2017/1/24.
 */
interface I1 {
    void f();
}

interface I2 {
    int f(int i);
}
interface I3 {
    int f();
}
class C {
    public int f() {
        return 1;
    }
}

class C2 implements I1,I2 {
    @Override
    public void f() {

    }

    @Override
    public int f(int i) {
        return 0;
    }
}

class C3 extends C implements I2 {
    @Override
    public int f(int i) {
        return 0;
    }
}

class C4 extends C implements I3 {
    @Override
    //重写
    public int f() {
        return super.f();
    }
}

class theA {
    public int f() {
        return 1;
    }
}
class theB extends theA {
    public int f() {
        return 4;
    }
    public void show() {
        f();
    }
}

//尽量不要在打算组合的接口中使用相同的方法名
//class C5 extends C implements I1 {
//   //重写，重载，实现 混在了一起，但是重载仅仅通过返回值类型无法区分
//    public int f() {
//        return 1;
//    }
//    public void f() {
//
//    }
//
//}



public class NameFire {
}
