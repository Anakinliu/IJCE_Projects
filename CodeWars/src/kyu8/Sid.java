package kyu8;
/*
https://www.codewars.com/kata/57f24e6a18e9fad8eb000296
 */
/*
    AUTHOR: linux
    TIME: 2019/11/11
    GOOD LUCK AND NO BUG.
*/
public class Sid {
    private static String[] PETAL =
            new String[]{
                    "I love you",
                    "a little",
                    "a lot",
                    "passionately",
                    "madly",
                    "not at all"};
    public static String howMuchILoveYou(int nb_petals) {
        //your code here :)

        return PETAL[(nb_petals-1) % 6];
    }

    // 解法2
    public static String howMuchILoveYou_2(int nb_petals) {
        // 直接调整petal顺序！！！
        String[] petal =
                new String[]{
                        "not at all",
                        "I love you",
                        "a little",
                        "a lot",
                        "passionately",
                        "madly"
                        ,};
        return petal[nb_petals % 6];
    }

    public static void main(String[] args) {

    }
}
