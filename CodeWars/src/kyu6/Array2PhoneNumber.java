package kyu6;

import java.util.Arrays;

/*
    AUTHOR: linux
    TIME: 2019/11/11
    GOOD LUCK AND NO BUG.
*/
public class Array2PhoneNumber {

    public static String createPhoneNumber(int[] numbers) {
        StringBuffer sb = new StringBuffer();
        sb.append("(");
        int count = 0;
        for (int i : numbers) {
            sb.append(i);
            count++;
            if (count == 3){
                sb.append(") ");
            }
            if (count == 6) {
                sb.append("-");
            }
        }
        return sb.toString();
    }
    //
    private static String PHONE_FORMAT = "(%d%d%d) %d%d%d-%d%d%d%d";

    public static String createPhoneNumber_1(int[] numbers) {
        // 将基本类型包装成为对象，以在format方法中使用
        Integer[] numbersInt = Arrays.stream(numbers).boxed().toArray(Integer[]::new);

        return String.format(PHONE_FORMAT, numbersInt);
    }
    //


    public static void main(String[] args) {
        System.out.println(createPhoneNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
    }
}
