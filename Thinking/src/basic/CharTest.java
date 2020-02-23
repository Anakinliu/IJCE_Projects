package basic;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/*
    AUTHOR: linux
    TIME: 2018/5/13
    GOOD LUCK AND NO BUG.
*/
public class CharTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        // TODO char的大小取决于编码方式, utf一般3位, gbk一般2位

        char x = 'm';
        char re = Character.reverseBytes(x);
        System.out.println(re);

        String m = "檞";
        byte[] bs = m.getBytes("UTF-8");
        System.out.println("UTF-8 " +  Arrays.toString(bs));
        System.out.println("UTF-8 " + bs.length);

        bs = m.getBytes("GBK");
        System.out.println("GBK " + Arrays.toString(bs));
        System.out.println("GBK " + bs.length);

        char n = 127 + 1000;
        System.out.println(++n);
        System.out.println(n++);
    }
}
