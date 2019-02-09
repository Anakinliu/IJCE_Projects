/*
    AUTHOR: linux
    TIME: 2019/1/31
    GOOD LUCK AND NO BUG.
*/
public class TestMyException {
    public static void show(int x) throws MyException {
        if (x == 0) {
            throw new MyException("你弄啥来?");
        }
    }
    public static void main(String[] args) throws MyException {
        show(0);

    }
}
