package top.pythonet.Start.real_class;

import top.pythonet.Start.interfaces.FlyBehavior;

/*
    AUTHOR: linux
    TIME: 2018/4/13
    GOOD LUCK AND NO BUG.
*/
public class FlyWithRocket implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Now I can fly with Rocket");
    }
}
