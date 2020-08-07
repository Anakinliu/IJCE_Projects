package chapter1.se3;
import chapter1.se2.Calculator;

public class PrimeGenerator extends Thread {

    @Override
    public void run() {
        long number = 1L;
        while (true) {
            if (Calculator.isPrime(number)){
                System.out.printf("Number %d is Prine \n", number);
            }

            /*
            *每处理完一个数字，
            * 通过isInterrupted()方法来判断当前线程是否已被中断。
            * 如果该方法返回true，那么表明当前线程已被中断。
            * */
            if (isInterrupted()) {
                System.out.println("The Prime generator has been Interrupted");
                return;
            }
            number ++;
        }
    }
}
