package com.Works;

import java.util.Calendar;
import java.util.Scanner;

/**
 * Created by liu_y.
 * On 2016/10/21.
 */
public class AllNunber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        //char[]	toCharArray()
        //将此字符串转换为一个新的字符数组。
        char[] cs = s.toCharArray();
        int result = 0;
        System.out.println("输入：");
        for (int i=0; i<s.length(); i++) {
            result = Character.getNumericValue(cs[i]) * (int)Math.pow(10.0,s.length()-1-i) + result;
        }
        System.out.println(result);
    }
}
