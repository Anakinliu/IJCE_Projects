package kyu7;

/*
    AUTHOR: linux
    TIME: 2019/11/10
    GOOD LUCK AND NO BUG.
*/

public class Square {
    public static boolean isSquare(int n)
    {
        if (n < 0) {
            return false;
        } else {
            return Double.compare(Math.sqrt(n),
                    Math.floor(Math.sqrt(n))) == 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(1.0 == 1);
    }
}
