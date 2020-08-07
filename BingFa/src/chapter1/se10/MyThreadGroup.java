package chapter1.se10;

public class MyThreadGroup extends ThreadGroup{

    public MyThreadGroup(String name) {
        super(name);
    }

    /*
    重写uncaughtException()方法。ThreadGroup类中的任意一个线程抛出异常，
    都将调用该方法
    同时需要注意，该方法会中断线程组中的其余线程：

    ThreadGroup类存储了关联的线程对象及关联的其他线程组对象，
    因此它可以对其组成员进行信息访问（如状态信息）
    和
    控制（如中断控制）。
    * */

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        // 线程组中任意线程抛出异常后，
        // 触发了其uncaughtException()方法。
        // 该方法紧接着中断了其余线程
        System.out.printf("The Thread %s has thrown Exception\n",
                t.getId());
        e.printStackTrace();
        System.out.println("Terminating the rest of the Threads\n");
        interrupt(); // 中断线程组中的其余线程
    }
}
