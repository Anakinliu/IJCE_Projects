package kyu6;

import java.util.HashSet;

/*
    AUTHOR: linux
    TIME: 2020/3/5
    GOOD LUCK AND NO BUG.
*/
/*
https://www.codewars.com/kata/545cedaa9943f7fe7b000048/solutions/java

Pangram 全字母短句(指包括英语全部26个字母的短句)
大小写都可以

 */
public class Detect_Pangram {
    public static boolean check(String sentence){
        char[] chars = sentence.toCharArray();
        HashSet<Character> alphabeticSet = new HashSet<>();
        for (char ch : chars) {
            if (Character.isAlphabetic(ch)) {
                // 统一视为小写
                alphabeticSet.add(Character.toLowerCase(ch));
            }
        }
        if (alphabeticSet.size() != 26) {
            return false;
        }
        return true;
    }


    // 答案之一 大佬的思路就是不一样
    public boolean check2(String sentence){
        for (char c = 'a'; c<='z'; c++)
            if (!sentence.toLowerCase().contains("" + c))
                return false;
        return true;

    }

    // 答案之二  又是stream。。。
    boolean check3(final String sentence) {
        return sentence.chars()
                .filter(Character::isLetter)
                .map(Character::toLowerCase)
                .distinct()
                .count() == 26;
    }

    public static void main(String[] args) {
        String pangram1 = "The quick brown fox jumps over the lazy dog.";
        System.out.println(check(pangram1));
    }
}
