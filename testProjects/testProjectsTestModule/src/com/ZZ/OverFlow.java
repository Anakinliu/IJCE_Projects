package com.ZZ;

import java.util.*;
/**
 * Created by liu_y.
 * On 2016/9/15.
 */
public class OverFlow {
    public static void main(String[] args) {
        double jiao = 0;
        System.out.println("输入工资");
        Scanner input = new Scanner(System.in);
        double s = input.nextDouble();
        double k = s - 3500.0;
        if (k > 80000.0) {
            jiao = (k - 80000.0) * 0.45 + 25000 * 0.35 + 20000 * 0.3 + 26000 * 0.25 + 4500 * 0.2 + 3000 * 0.1 + 1500 * 0.03;
        }
        else if (k > 55000) {
            jiao = (k - 55000) * 0.35 + 20000 * 0.3 + 26000 * 0.25 + 4500 * 0.2 + 3000 * 0.1 + 1500 * 0.03;
        }
        else if (k > 35000) {
            jiao = (k - 35000) * 0.3 + 26000 * 0.25 + 4500 * 0.2 + 3000 * 0.1 + 1500 * 0.03;
        }
        else if (k > 9000) {
            jiao = (k - 9000) * 0.25 + 4500 * 0.2 + 3000 * 0.1 + 1500 * 0.03;
        }
        else if (k > 4500) {
            jiao = (k - 4500) * 0.2 + 3000 * 0.1 + 1500 * 0.03;
        }
        else if (k > 1500) {
            jiao = (k - 1500) * 0.1 + 15000 * 0.03;
        }
        else if (k <= 1500&&k > 0) {
            jiao = k*0.03;
        }
        else if (k <= 0) {
            jiao = 0;
        }
        System.out.println("应缴纳税额是");
        System.out.println(jiao);
        System.out.println("税后");
        System.out.println(s - jiao);
    }
}
