package com.youku.demo;

/**
 * Created by liu_y on 2016/7/14.
 */
public class helloWorld {
    public static  int y ;
    //类变量（静态变量）
    //在类中以static关键字声明，但必须在方法构造方法和语句块之外。
    //静态变量除了被声明为常量外很少使用
    //静态变量储存在静态存储区。经常被声明为常量，
    // 很少单独使用static声明变量。
    //与实例变量具有相似的可见性。但为了对类的使用者可见，
    // 大多数静态变量声明为public类型。
    public static final float S= 100f;//加f，如果加小数点就被认为是double
    //类变量被声明为public static final类型时，
    // 类变量名称必须使用大写字母。
    // 如果静态变量不是public和final类型，
    // 其命名方式与实例变量以及局部变量的命名方式一致。





    public int r;
    private int t;
    //实例变量声明在一个类中，但在方法、构造方法和语句块之外,
    //声明方式同静态变量。
    //实例变量在对象创建的时候创建，在对象被销毁的时候销毁；
    //实例变量的值应该至少被一个方法、构造方法或者语句块引用，
    // 使得外部能够通过这些方式获取实例变量信息；
    //实例变量可以直接通过变量名访问。但在  静态方法  以及  其他类  中，
    // 就应该使用完全限定名：ObejectReference.VariableName。
    public void myPublic(){
        int u=0;
        //局部变量被声明后，没有默认值,必须经过初始化,才可以使用;
        //局部变量声明在方法、构造方法或者语句块中；
        //局部变量在方法、构造方法、或者语句块被执行的时候创建，
        // 当它们执行完成后，变量将会被销毁；
        //访问修饰符不能用于局部变量；
        //局部变量只在声明它的方法、构造方法或者语句块中可见；
        //局部变量是在栈上分配的。
        //局部变量没有默认值，所以局部变量被声明后，必须经过初始化，才可以使用。
        r=z;

    }
    public int z;
    //实例变量
    //实例变量可以在  使用后  声明；


   void noMAin(){

        byte x;
        //byte是8位、有符号的，以二进制补码表示的整数；
        short sho;
        //short数据类型是16位、有符号的以二进制补码表示的整数
        int in;
        //int数据类型是32位、有符号的以二进制补码表示的整数；
        long lo=6L;
        //long数据类型是64位、有符号的以二进制补码表示的整数；

        x = 016;
        y=x;
        newWorld nW=new newWorld();
        nW.printIt();
        helloWorld hW=new helloWorld();
        hW.z=99;
        System.out.println("z="+hW.z);
        System.out.println("r="+hW.r);
        hW.myPublic();
        System.out.println("r="+hW.r);

        System.out.println("\"Hello\"\n\"world\"");
        System.out.println("x="+x+","+"y = " + y);

        System.out.println();
    }
}
