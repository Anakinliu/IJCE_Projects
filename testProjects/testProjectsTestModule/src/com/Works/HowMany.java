package com.Works;

import java.util.Scanner;

/**
 * Created by liu_y.
 * On 2016/10/20.
 */
public class HowMany {
    public static void main(String[] args) {
        System.out.println("Input:");
        Scanner input = new Scanner(System.in);
        //Character ch = new Character();
        String s = new String(input.nextLine());
        int low=0,up=0,num=0,other=0;
        //s.charAt(0);
        for (int i=0; i<s.length(); i++) {
            if (Character.isLowerCase(s.charAt(i))) {
                low++;
            }
            else if (Character.isUpperCase(s.charAt(i))) {
                up++;
            }
            else if (Character.isDigit(s.charAt(i))) {
                num++;
            }

            else if (!Character.isSpaceChar(s.charAt(i))){
                other++;
            }
        }
        System.out.println("Lower count: " + low + "\nUpper count: " + up + "\nNumber count: " + num + "\nOther count: " + other);
    }
}
