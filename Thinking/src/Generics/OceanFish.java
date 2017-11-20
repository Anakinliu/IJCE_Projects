package Generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Anakinliu on 2017/8/31.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
class BigFish {
    private static long counter = 1;
    private final long id = counter++;
    private BigFish() {}
    @Override
    public String toString() {
        return "BigFish" + id;
    }
    public static Generator<BigFish> generator() {
        return BigFish::new;
    }

}
class LittleFish {
    private static long counter = 1;
    private final long id = counter++;
    private LittleFish() {}

    @Override
    public String toString() {
        return "LittleFish" + id;
    }

    public static Generator<LittleFish> generator =
            LittleFish::new;


}
/*
小鱼吃大鱼
 */
public class OceanFish {
    public static void show(LittleFish lf, BigFish bf) {
        System.out.println(lf + " eat " + bf);
    }

    public static void main(String[] args) {
        Random rand = new Random(123456);
        List<BigFish> bigFishList =
                new ArrayList<>();
        Generators.fill(bigFishList, BigFish.generator(), 10);
        List<LittleFish> littleFishList =
                new ArrayList<>();
        Generators.fill(littleFishList, LittleFish.generator, 2);
        for (BigFish bigFish : bigFishList) {
            show(littleFishList.get(rand.nextInt(littleFishList.size())), bigFish);

        }
    }
}
