package com.ZZ;

import java.util.Scanner;

/**
 * Created by liu_y.
 * On 2016/9/21.
 */
class Elemen {
    int index;
    int value;
    Elemen left;
    Elemen right;
}

public class InsertElemen {
    static int correntCount = 0;
    Elemen first;
    Elemen last;


    public void addElemen(int n) {
        for (int i=0; i<n; i++) {
            Elemen e = new Elemen();
            e.index = correntCount;
            Scanner input = new Scanner(System.in);
            e.value = input.nextInt();
            if (correntCount == 0) {
                first = e;
                e.left = e;
                e.right = e;
                last = e;
            } else {
                last.right = e;
                e.left = last;
                last = e;
                e.right = null;
            }
            correntCount++;
        }
    }

    public void print() {
        Elemen temp = new Elemen();
        temp = first;
        System.out.println(temp.left.left.index);
//        for (int i=0; i<correntCount - 1; i++) {
//            System.out.print(temp.index + " ");
//            temp = temp.left;
//        }
    }
    public static void main(String[] args) {
        InsertElemen s = new InsertElemen();
        s.addElemen(5);

        s.print();
    }
}
