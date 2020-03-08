package kyu6;

import java.util.LinkedList;
import java.util.stream.Collectors;

/*
    AUTHOR: linux
    TIME: 2020/3/8
    GOOD LUCK AND NO BUG.
*/
/*
假设#与backspace的效果一样，

Examples
"abc#d##c"      ==>  "ac"
"abc##d######"  ==>  ""
"#######"       ==>  ""
""              ==>  ""
 */
public class Backspaces_in_string {
    public static String cleanString(String s) {
        // your code here
        char[] chars = s.toCharArray();
        LinkedList<Character> resultList = new LinkedList<>();
        for (char c : chars) {
            if (c == '#') {
                if (!resultList.isEmpty()) {
                    resultList.removeLast();
                }
            } else {
                resultList.addLast(c);
            }
        }
        return resultList.stream().map(String::valueOf).collect(Collectors.joining());
    }

    // 答案之一，正则大佬
    public static String cleanString2(String s) {
        // [^#]匹配非 # 字符， 这个while循环就是删除字符
        while (s.matches(".*[^#]#.*"))
            s = s.replaceAll("[^#]#", "");
        // 这是只有 # 字符的情况
        return s.replaceAll("#","");
    }

    // API大佬，setLength变小，自动裁剪字符
    public String cleanString3(String s) {
        StringBuilder b = new StringBuilder();
        for(int i=0; i<s.length(); ++i) {
            char c = s.charAt(i);
            if(c=='#') b.setLength(Math.max(b.length()-1,0));
            else b.append(c);
        }
        return b.toString();
    }
    public static void main(String[] args) {
        System.out.println(cleanString("abc#d##c"));
    }
}
