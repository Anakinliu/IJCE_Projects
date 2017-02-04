import static java.lang.Float.NaN;

/**
 * Created by Anakinliu on 2017/1/13.
 */
public class NaNTest {
    public static void main(String[] args) {
        System.out.println("NaN == 7.0 :" + (NaN == 7.0 ));
        System.out.println("NaN != 7.0 :" + (NaN != 7.0 ));
        System.out.println("NaN == NaN :" + (NaN == NaN));
        System.out.println("NaN != NaN :" + (NaN != NaN));
    }
}
