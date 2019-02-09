/*
    AUTHOR: linux
    TIME: 2019/1/31
    GOOD LUCK AND NO BUG.
*/
public class Test {
    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        while ((y = x) != -1) {
            x--;
            System.out.println(y);
        }
    }
}
