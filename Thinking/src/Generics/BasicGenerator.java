package Generics;

/**
 * Created by Anakinliu on 2017/8/29.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */

/*
此类可以生成某个类的对象, 但是这个被生成的需要为public, 具备无参构造器
使用create方法传入要生成的类型
 */

public class BasicGenerator<T> implements Generator<T>  {
    private Class<T> type;

    public BasicGenerator(Class<T> type) {
        this.type = type;
    }

    @Override
    public T next() {
        try {
            // type类必须为公共类
            return type.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //还记得吗, static方法要想使用泛型, 必须将自身设为泛型方法, 将泛型参数列表放在返回值之前!
    public static <T> BasicGenerator<T> create(Class<T> type) {
        return new BasicGenerator<>(type);
    }
}

