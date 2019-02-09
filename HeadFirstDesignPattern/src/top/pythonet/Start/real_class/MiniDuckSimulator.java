package top.pythonet.Start.real_class;

import top.pythonet.Start.abstract_class.Duck;

/*
    AUTHOR: linux
    TIME: 2018/4/13
    GOOD LUCK AND NO BUG.
*/
public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performFly();
        mallard.performQuack();

        // 动态改变飞行方式
        mallard.setFlyBehavior(new FlyWithRocket());
        mallard.performFly();
    }
}
