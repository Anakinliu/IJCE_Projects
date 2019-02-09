import java.io.IOException;

/*
    AUTHOR: linux
    TIME: 2019/1/29
    GOOD LUCK AND NO BUG.
*/
public class TestSystemIn {
    public static void main(String[] args) throws IOException {
        int b = System.in.read();
        System.out.println("read data : " + (char) b);

    }
}
