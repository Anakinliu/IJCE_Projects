package com.ThingInJava;

/**
 * Created by liu_y.
 * On 2016/10/2.
 */
public class GoTo {
    public static void main(String[] args) {

        int a = 0;

        outer:
        for (;true;) {
            System.out.println("first for");
            inner:
            for(;a<15;a++) {
                System.out.println("a= " + a);
                if (a==1) {
                    System.out.println("continue inner");
                    continue ;
                }
                if (a==2) {
                    System.out.println("break inner");
                    a++;//break后for里的a++不执行了
                    break ;
                }
                if (a==5) {
                    System.out.println("continue outer");
                    a++;//for里的a++不执行了
                    continue outer;
                }
                if (a==7) {
                    System.out.println("break outer");
                    break outer;
                }
                System.out.println("continue inner");
            }
        }
    }
}
