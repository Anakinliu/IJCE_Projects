package InnerClass;

/**
 * Created by Anakinliu on 2017/2/8.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
class Practice15Child {
    public Practice15 makePractice15() {
        return new Practice15(9.9) {

        };
    }
}

public class Practice15 {
    private double x;

    public Practice15(double x) {
        this.x = x;
    }




}
