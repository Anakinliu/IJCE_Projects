package kyu6;

/*
    AUTHOR: linux
    TIME: 2020/3/7
    GOOD LUCK AND NO BUG.
*/
/*
返回连续的辅音组成的子字符串的最大值

元音 aeiou
 */

public class Consonant_value {
    public static int solve(final String s) {
//        HashSet<Character> alphaSet = new HashSet<>();
//        for (char c = 'a'; c <= 'a' + 25; c++) {
//            alphaSet.add(c);
//        }
        final String vowels = "aeiou";
//        System.out.println(alphaSet);
        char[] charOfS = s.toCharArray();
        int max = 0;
        int sum = 0;
        for (char c: charOfS) {
            if (vowels.contains("" + c)) {
                if (sum > max) {
                    max = sum;
                }
                sum = 0;
                continue;
            }else {
                sum +=  (c - 96);
            }
        }
        if (sum > max) {
            max = sum;
        }
        return max;
    }

    public static void main(String[] args) {
        solve("az");

//        int c = 'a';
//        System.out.println(c);
    }
}
