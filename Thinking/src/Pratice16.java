import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Anakinliu on 2017/1/29.
 */
class GetChar implements Readable {
    private static Random random = new Random(47);

    private int count;

    private char[] alpha = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public GetChar(int count) {
        this.count = count;
    }

    public  char getChar() {
        return alpha[random.nextInt(alpha.length)];
    }

    @Override
    public int read(@NotNull CharBuffer cb) throws IOException {
        if (count-- == 0) {
            return -1;
        }
        else {
            cb.append(getChar() + " ");
            return 1;
        }
    }
}
public class Pratice16 {
    public static void main(String[] args) {
        Scanner s = new Scanner(new GetChar(6));
        while (s.hasNext()) {
            System.out.println(s.next());
        }
    }
}
