package cn.bupt.john.hash;

import java.util.*;

/**
 * 思路：
 * <p>
 *     维护一个set
 *     如果string length=1, 直接加入set
 *     如果set中存在s.substring(0, s.length-1), 则加入set，并设置最大值result。
 * </p>
 */
public class P720_LongestWordInDictionary {

    public static void main(String[] args) {
        P720_LongestWordInDictionary solution = new P720_LongestWordInDictionary();
        System.out.println(solution.longestWord(new String[] {"w","wo","wor","worl", "world"}));
    }

    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> set = new HashSet<>();
        String result = "";
        for (String s : words) {
            if (s.length() ==1 || set.contains(s.substring(0, s.length()-1))) {
                set.add(s);
                if (s.length()>result.length()) {
                    result = s;
                }
            }
        }
        return result;
    }
}
