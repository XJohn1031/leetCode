package cn.bupt.john.hash;

import java.util.HashMap;
import java.util.Map;

public class P242_ValidAnagram {

    public static void main(String[] args) {
        P242_ValidAnagram solution = new P242_ValidAnagram();
        System.out.println(solution.isAnagram("nagaram", "anagram"));
    }

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> sMap = new HashMap<>(s.length());
        HashMap<Character, Integer> tMap = new HashMap<>(t.length());
        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();
        for (int i = 0; i < schar.length; i++) {
            if (sMap.containsKey(schar[i])) {
                sMap.put(schar[i], sMap.get(schar[i]) + 1);
            }
            else {
                sMap.put(schar[i], 1);
            }
        }
        for (int i = 0; i < tchar.length; i++) {
           if (tMap.containsKey(tchar[i]))  {
               tMap.put(tchar[i], tMap.get(tchar[i]) + 1);
           }
           else {
               tMap.put(tchar[i], 1);
           }
        }
        for (Map.Entry entry : sMap.entrySet()) {
            int result = (int) entry.getValue();
            Character key = (Character) entry.getKey();
            if (tMap.get(key) == null || tMap.get(key) != result) {
                return false;
            }

        }
        return true;
    }

}
