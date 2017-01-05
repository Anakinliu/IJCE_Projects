package com.ThingInJava;

/**
 * Created by liu_y.
 * On 2016/10/22.
 */
class Book {
    private Book() {
        //构造方法是隐藏的
    }
    public static Book makeBook() {
        return new Book();
        //通过此静态方法才能创建Book对象
    }
}
public class PrivateExample {
    public static void main(String[] args) {
        //!!!Book book1 = new Book();
        Book book1 = Book.makeBook();
    }
}
