package com.ZZ;

/**
 * Created by liu_y.
 * On 2016/9/16.
 */
public class Count3Quit {
    public static void main(String[] args) {
        boolean[] array;
        array = new boolean[500];
        int i;
        for (i=0;i < array.length;i++) {
            array[i] = true;
        }

        int index = 0;
        int leftLength = array.length;
        int count = 0;
        while(leftLength > 1) {
            if (array[index] == true) {
                count++;
                if (count == 3) {
                    count = 0;
                    array[index] = false;
                    leftLength--;
                }
            }
            index++;
            if (index >= 500) {
                index = 0;
            }
        }

        for (index = 0;index < array.length;index++) {
            if (array[index] == true) {
                System.out.println(index + 1);
            }
        }

    }
}
