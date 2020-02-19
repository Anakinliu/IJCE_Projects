package kyu6;

import java.util.HashMap;

/*
    AUTHOR: linux
    TIME: 2020/2/19
    GOOD LUCK AND NO BUG.
*/
public class Counting_Duplicates {
    public static int duplicateCount(String text) {
        // text中有几种重复的字符，text只包含字母和数字,不区分大小写！！！！
        text = text.toLowerCase();
        HashMap<Character, Integer> countMap = new HashMap<Character, Integer>();
        char[] charArray = text.toCharArray();
        for (char c : charArray) {
            int count = countMap.getOrDefault(c, 0);
            countMap.put(c, count + 1);
        }
        int result = 0;
        for (Integer i : countMap.values()) {
            if (i > 1) {
                result++;
            }
        }
        return result;
    }
    // 答案之一剖析  不同的思路哦
    public static int duplicateCount2(String text) {
        int ans = 0;
        text = text.toLowerCase();
        while (text.length() > 0) {
            String firstLetter = text.substring(0,1);  // 得到text第一个字符
            text = text.substring(1);  // 去掉text第一个字符
            if (text.contains(firstLetter)) ans ++;  // 直接使用contains方法判断
            text = text.replace(firstLetter, "");  // 去掉所有重复的字符
        }
        return ans;
    }

    public static void main(String[] args) {
        String test = "abcdeaBReturnsTwo";
        System.out.println(duplicateCount(test));
    }
}
