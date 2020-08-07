package chapter1.se8;

public class Main {
    public static void main(String[] args) {
        Task task = new Task();
        Thread thread = new Thread(task);
        /*
        * 如果线程对象没有配置未捕获异常处理器，
        * 则JVM会在控制台中打印出异常信息栈，然后结束异常抛出线程的执行
        * */
//        thread.setUncaughtExceptionHandler(new ExceptionHandler());

        /*
        *为应用中所有线程对象设置默认的未捕获异常处理器
        * */
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());

        thread.start();
    }
}
