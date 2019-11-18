import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/*
    AUTHOR: linux
    TIME: 2019/2/9
    GOOD LUCK AND NO BUG.
*/
public class TestFileInputStream {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("IN.txt");
        int temp;
        // 读取整型
        /*while ((temp = inputStream.read()) != -1) {
            System.out.println((char)temp);
        }*/
        byte[] bytes = new byte[3];
        System.out.println("---");
        // 填充数组时根据读取到的字节来, 未填充的还会保留上次的
        while ((temp = inputStream.read(bytes)) != -1) {
            System.out.println(Arrays.toString(bytes));
        }
        inputStream.close();
    }
}
