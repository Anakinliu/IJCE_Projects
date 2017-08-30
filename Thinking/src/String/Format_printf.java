package String;

import java.io.PrintStream;
import java.util.Formatter;
import java.util.Locale;

/**
 * Created by Anakinliu on 2017/7/9.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class Format_printf {
    static Formatter f;
    static StringBuffer stringBuffer;
    public static void main(String[] args) {
        stringBuffer = new StringBuffer();
        PrintStream ps = System.out;
        // 将所有输出放到可追加的对象上
        f = new Formatter(ps, Locale.CHINA);
        // 更改参数次序
        f.format("%2$d %1$d\n", 2, 1);

        // 逗号分割整数
        f.format("Amount gained or lost since last statement: $ %(,d\n",
                10000000);
        System.out.println(stringBuffer);

        System.out.printf("I'm %d years old.\n", 20);
        System.out.format("Oh, I had %d party.\n", 20);
    }
}
