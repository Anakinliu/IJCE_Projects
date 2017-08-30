package polymorphismANDinterface;

/**
 * Created by Anakinliu on 2017/1/18.
 */
interface Processor2 {
    String name();
    Object process(String input);
}
class ChangeEachTwoChar {
    public static String change (String s) {
        int l = s.length();
        char sc[] = s.toCharArray();
        char temp;
        for (int i=0; i+1<l; i+=2) {
            temp = sc[i];
            sc[i] = sc[i+1];
            sc[i+1] = temp;
        }
        return new String(sc);
    }
}
public class StringProcessor implements Processor2 {
    @Override
    public String name() {
        return null;
    }

    @Override
    public StringProcessor process(String input) {
        return null;
    }

    public static void main(String[] args) {
        System.out.println(ChangeEachTwoChar.change("liuyinquan23"));
    }
}

