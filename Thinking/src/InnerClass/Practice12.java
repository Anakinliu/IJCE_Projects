package InnerClass;

/**
 * Created by Anakinliu on 2017/2/8.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class Practice12 {
    private String s = " ";

    private void show() {
        System.out.println(s);
    }

    class Inner12 {
        public void changeS () {
            s = "zero";
            show();
        }
    }

    public Inner12 getInner() {
        return new Inner12() {
            @Override
            public void changeS() {
                super.changeS();
            }
        };
    }

    public static void main(String[] args) {
        Practice12 practice12 = new Practice12();
        practice12.show();

        practice12.getInner().changeS();

        practice12.show();
    }



}
