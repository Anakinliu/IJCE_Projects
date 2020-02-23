package Containers;

import java.util.ArrayList;


/*
    AUTHOR: linux
    TIME: 2018/5/7
    GOOD LUCK AND NO BUG.
*/
// 所有Collection子类型都有一个接收另一个Collection对象的构造器,
// 使用所接收的Collection的元素用来填充新容器

// 测试数据用类
// 使用Generator在容器中放置所需数量的对象, 然后产生的容器可以传递给任何Collection的构造器
// 泛型的方法可以减少使用类时的类型检查
public class CollectionData<T> extends ArrayList<T> {
    public CollectionData(Generator<T> gen, int quantity) {
        for (int i = 0; i < quantity; i++) {
            add(gen.next());
        }
    }

    // A generic convenience method
    public static <T> CollectionData<T> list(Generator<T> gen, int quantity) {
        return new CollectionData<>(gen, quantity);
    }
}

interface Generator<T> {
    T next(); //该方法用以产生新的对象
}