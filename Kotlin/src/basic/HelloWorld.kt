package basic


/*
    AUTHOR: linux
    TIME: 2018/5/13
    GOOD LUCK AND NO BUG.
*/

// 入口函数
fun main(args: Array<String>) {
    println("Hello, china!")

    println(Bed(2,"l"))

    println(Person(1, "q"))
}

class Bed(id: Int, name: String)

// data class会重写toString方法
data class Person(var id: Int,var sex: String)