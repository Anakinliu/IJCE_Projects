package com.bilibili;

/**
 * Created by liu_y.
 * On 2016/9/14.
 */
class PriNumber {
    int number;

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    protected boolean isPriNumber() {
        int i;
        boolean is = true;
        for (i=2;i<number;i++) {
            if (number % i == 0) {
                is = false;
                break;
            }
        }
        return is;
    }

}
public class TestBreak {
  //  利用循环语句和break语句，
  //  编程求出100—200之间所有素数的和。
  //  所谓素数是指除了1和它本身外，不能再被其它数整除的数。
    public static void main(String[] args) {
        PriNumber pri = new PriNumber();
        long sumResult = 0;
        for (int i=100;i<=200;i++) {
            pri.setNumber(i);
            if (pri.isPriNumber()) {
                sumResult = sumResult + pri.getNumber();
            }
        }
        System.out.println(sumResult);
    }
}
