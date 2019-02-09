package Tools;

import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by Anakinliu on 17.10.24.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public final class GenerateManyThings {

    private static Out out =
            new Out("E:\\IJCE\\Algorithms4th\\src\\Fundamentals\\in.txt");

    /*
    write int from [0 ~ basicNumber] in counts times
    if number is int, short, long, byte, then generate some int
    if number is float or double, then generate some x.xx
     */
    public static void generateAllNumber(int counts, Number number) {
        if (counts <= 0) {
            return;
        }

        // 判断参数是整数或者浮点
        final String realType = number.getClass().getSimpleName();
        final String format;
        switch (realType) {
            case "Byte":
            case "Long":
            case "Short":
            case "Integer":
                format = "%.0f ";
                break;
            case "Float":
            case "Double":
                format = "%.2f ";
                break;
            default: format = "%s ";

        }

        for (int i = 1; i <= counts; i++) {
            out.printf(format, (number.doubleValue() * StdRandom.uniform()));
            // 换行
//            if (i % 7 == 0) {
//                out.println();
//            }
        }
    }

    private GenerateManyThings() {
    }

    public static void main(String[] args) {
        generateAllNumber(50, 100);
    }
}
