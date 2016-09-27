package com.tudou.demo;

/**
 * Created by liu_y.
 * On 2016/8/9.
 */
public class SuShu {
    public static void main(String[] args) {
        boolean flag;

        for (int n=101; n<200; n+=2) {
            flag=false;
            for (int m = 2; m < n; m++){
                if (n%m == 0) {
                 flag=true;
                    break;
                }

            }
            if (flag)
                continue;
            System.out.print(n+"  ");
        }
    }
}
