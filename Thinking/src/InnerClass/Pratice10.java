package InnerClass;

/**
 * Created by Anakinliu on 2017/2/6.
 * GO! GO! GO!
 */

public class Pratice10 {
    private class Inner implements Pratice {
        @Override
        public void show() {

        }
    }

    public Pratice getPratice() {
        return new Pratice10.Inner();
    }
}
