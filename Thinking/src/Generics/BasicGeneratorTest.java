package Generics;

/**
 * Created by Anakinliu on 2017/8/29.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class BasicGeneratorTest {
    private static int counter;

    public BasicGeneratorTest() {
    }

    @Override
    public String toString() {
        return "Test Object" + (++counter);
    }

    public static void main(String[] args) {
        Generator<BasicGeneratorTest> gen =
                BasicGenerator.create(BasicGeneratorTest.class);
        for (int i = 0; i < 5; i++) {
            System.out.println(gen.next());
        }

        // 下面直接调用构造器创建Generator
        Generator<BasicGeneratorTest> directGen =
                new BasicGenerator<>(BasicGeneratorTest.class);
        for (int i = 0; i < 5; i++) {
            System.out.println(directGen.next());
        }
    }
}
