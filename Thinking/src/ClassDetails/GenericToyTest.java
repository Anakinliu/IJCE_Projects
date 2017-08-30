package ClassDetails;

/**
 * Created by Anakinliu on 2017/7/20.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
class VeryFancyToy extends FancyToy {}
public class GenericToyTest {
    public static void main(String[] args) {
        Class<FancyToy> ftToy = FancyToy.class;

        // 不能精确到某一个基类, 编译错误!
        // !Class<Toy> up1 = ftToy.getSuperclass();

        // 含糊的Class引用
        Class up2 = ftToy.getSuperclass();

        // newInstance()返回Object引用!
        // 需要强制类型转换!
        try {
            Toy up2toy = (Toy)up2.newInstance();
            up2toy.showSelf();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // 指明了up3是Fancy的一个基类的Class引用
        Class<? super FancyToy> up3 = ftToy.getSuperclass();
        try {
            // 同样, newInstance()返回Object引用!
            Toy up3Toy = (Toy) up3.newInstance();
            up3Toy.showSelf();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // 本身类则不用强制类型转换
        try {
            FancyToy fancyToy = ftToy.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
