package top.pythonet.JavaMemoryModel;

/*
    AUTHOR: linux
    TIME: 2018/5/11
    GOOD LUCK AND NO BUG.
*/
public class SynchronizedDemo {
    //共享变量
    private boolean ready = false;
    //共享变量
    private int result = 0;
    //共享变量
    private int number = 1;

    /*
     TODO 1.X与2.X, 1.1与1.2, 2.1与2.2之间都有可能会发生指令重排序!!!
     TODO 进而导致最终结果result值的不确定性!
     TODO 虽然不加上synchronized也会有可见性, 但是无法百分之百保证!
     0，6的结果，也可能是读线程和写线程start后，谁先被cpu调度引起的。
     好像只加synchronized不能控制0，6的结果。需要利用线程同步的知识来解决。
     而sleep那个利用主线程阻塞的方式，很危险。那个sleep完全是经验值。
     如果写线程本身函数方法执行时间用时超过sleep时间或用时不定，结果就又会乱了。
      */
    //写操作
    public synchronized void write(){
        ready = true;	      				 //1.1
        number = 2;		                    //1.2
    }
    //读操作
    public synchronized void read(){
        if(ready){						     //2.1
            result = number*3;	 	//2.2
        }
        System.out.println("result值为: " + result);
    }

    //内部线程类
    private class ReadWriteThread extends Thread {
        //flag用来确定是写还是读
        private boolean flag;
        public ReadWriteThread(boolean flag){
            this.flag = flag;
        }
        @Override
        public void run() {
            if(flag){
                //?
                write();
            }else{
                //
                read();
            }
        }
    }

    // TODO 执行几次后, 必会发现result的值在0和6两者间飘忽不定!!
    /*
    因为线程的执行本身就是不确定的，加了synchronized关键字只能
    确保互斥访问这段代码以及变量的可见性，
    即某线程在修改共享变量（通过自己的工作内存来修改）时，
    其他的所有线程无法获得共享变量的信息。
    所以synchronized并不能保证程序的执行顺序。
    所以即使加了synchronized也可能会出现0。顺序是随机的，看jVM内存以及CUP的调度了。
     */
    public static void main(String[] args)  {
        SynchronizedDemo synDemo = new SynchronizedDemo();
        //实例化内部线程类, 注意内部类的实例化
        // 执行write
        synDemo.new ReadWriteThread(true).start();  //true执行write

        // TODO 我认为靠休眠保证结果不可取
        // 休眠主线程以便运行完write()线程, 使得共享变量可以更新到主内存
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //执行read, 从主内存读取共享变量到工作内存
        synDemo.new ReadWriteThread(false).start();

    }
}