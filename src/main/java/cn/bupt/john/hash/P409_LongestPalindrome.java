package cn.bupt.john.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 解题思路
 * <p>
 *     将每个字符都放入set中，如果set中已经存在，说明这个字符出现两次，result + 2，将该字符从set中移除
 *     最终结果 = result + set不为空？1 ：0
 * </p>
 */
public class P409_LongestPalindrome {

    public static void main(String[] args) {
        P409_LongestPalindrome solution = new P409_LongestPalindrome();
        System.out.println(solution.longestPalindrome("ddef"));
    }

    public int longestPalindrome(String s) {
        int result = 0;
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (set.contains(chars[i])) {
                result += 2;
                set.remove(chars[i]);
            }
            else {
                set.add(chars[i]);
            }
        }
        if (set.size() == 0) {
            return result;
        }
        else return result + 1;
    }
}
