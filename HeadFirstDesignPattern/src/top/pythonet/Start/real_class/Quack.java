package top.pythonet.Start.real_class;

import top.pythonet.Start.interfaces.QuackBehavior;

/*
    AUTHOR: linux
    TIME: 2018/4/13
    GOOD LUCK AND NO BUG.
*/
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println(this.getClass().getSimpleName());
    }
}
