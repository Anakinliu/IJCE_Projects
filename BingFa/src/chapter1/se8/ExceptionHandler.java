package chapter1.se8;

/*
* 实现一个处理非检查异常的类
* UncaughtExceptionHandle接口在Thread类的内部定义
* */
public class ExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        /*
        传入抛出的异常和线程本身
        * 输出异常和抛出线程信息
        * */
        System.out.println("An exception has been captured");
        System.out.println("Thread: " + t.getId());
        System.out.println("Exception: " + e.getClass().getName() +
                ": " + e.getMessage());
        System.out.println("Stack Trace:");
        e.printStackTrace();
        System.out.println("Thread status: " + t.getState());

    }
}
