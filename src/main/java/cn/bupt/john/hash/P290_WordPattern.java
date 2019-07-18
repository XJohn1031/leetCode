package cn.bupt.john.hash;

import java.util.HashMap;
import java.util.Objects;

public class P290_WordPattern {

    public static void main(String[] args) {
        P290_WordPattern solution = new P290_WordPattern();
        System.out.println(solution.wordPattern("abba", "dog pig dog dog"));
    }

    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || pattern.length() == 0) {
            return false;
        }
        String[] split = str.split(" ");
        char[] chars = pattern.toCharArray();
        if (chars.length != split.length) {
            return false;
        }
        HashMap<Character, Integer> charMap = new HashMap<>(chars.length);
        HashMap<String, Integer> stringMap = new HashMap<>(split.length);
        for (int i = 0; i < chars.length; i++) {
            if (!Objects.equals(charMap.get(chars[i]), stringMap.get(split[i]))) {
                return false;
            }
            charMap.put(chars[i], i);
            stringMap.put(split[i], i);
        }
        return true;
    }

}
