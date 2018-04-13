package top.pythonet.Start.abstract_class;

/*
    AUTHOR: linux
    TIME: 2018/4/13
    GOOD LUCK AND NO BUG.
*/

import top.pythonet.Start.interfaces.FlyBehavior;
import top.pythonet.Start.interfaces.QuackBehavior;

public abstract class Duck {
    protected FlyBehavior flyBehavior;
    protected QuackBehavior quackBehavior;

    public abstract void display();

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void swim() {
        System.out.println("all kind of dick can float!");
    }

}
