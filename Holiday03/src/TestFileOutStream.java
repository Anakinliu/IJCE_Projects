import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
    AUTHOR: linux
    TIME: 2019/2/9
    GOOD LUCK AND NO BUG.
*/
public class TestFileOutStream {
    public static void main(String[] args) throws IOException {
        /*FileOutputStream fileOutputStream =
                new FileOutputStream("OUT.txt", true);
        fileOutputStream.write(97);  //就是a
        fileOutputStream.write(98);
        fileOutputStream.write("\n".getBytes());
        fileOutputStream.close();*/
        float x = 1.0f, y = 0;
        y = x + 5.0f / 2;
        System.out.println(y);
    }
}
