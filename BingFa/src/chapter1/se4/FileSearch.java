package chapter1.se4;

import java.io.File;

/*
* 当一个线程有划分成多个方法的复杂算法，或者有递归调用时，
* 直接调用 task.interrupt() 并不管用。
* 我们需要更好的机制来控制中断。
* 为此，Java提供了InterruptedException异常，
* 可以在检测到线程中断Thread.interrupted()返回true后抛出该异常，
* 并在run()方法中捕获处理该异常。
* */

public class FileSearch implements Runnable {

    private String initPath;  // 要搜索的文件名
    private String fileName;  // 要搜索的初始路径

    public FileSearch(String initPath, String fileName) {
        this.initPath = initPath;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        File file = new File(initPath);
        if (file.isDirectory()) {
            try {
                directoryProcess(file);
            } catch (InterruptedException e) {
                // 处理中断抛出的异常
                System.out.println(Thread.currentThread().getName() + ": The search has been interrupted");
            }
        }
    }

    private void directoryProcess(File file) throws InterruptedException{
        /*
        这个方法会获取指定文件夹中的文件及其子文件夹，然后处理它们。
        对于每个子文件夹，该方法会以其作为参数递归调用自己；对于每个文件，
        该方法将调用fileProcess()方法进行处理。
        * */
        File list[] = file.listFiles();
        if (list != null) {
            for (int i = 0; i < list.length; i++) {
                if (list[i].isDirectory()) {
                    // 无论有多少次递归调用，只要它检测到中断，就会立即抛出InterruptedException异常，返回到run()方法中继续执行
                    directoryProcess(list[i]);
                } else {
                    fileProcess(list[i]);
                 }
            }
        }
    }

    private void fileProcess(File file) throws InterruptedException{
        /*
        对比文件名是否与所要搜索的文件名相同，如果相同，则向控制台输出信息
        * */
        if (file.getName().equals(fileName)) {
            System.out.printf("%s : %s\n", Thread.currentThread().getName(),
                    file.getAbsolutePath());
        }

        // 检测到自己被中断，此时简单的返回并不能中断线程，因为包含递归调用
        // 无论有多少次递归调用，只要它检测到中断，就会立即抛出InterruptedException异常，返回到run()方法中继续执行
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }

    }
}
