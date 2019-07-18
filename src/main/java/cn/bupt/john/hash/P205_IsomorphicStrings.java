package cn.bupt.john.hash;

import java.util.HashMap;

public class P205_IsomorphicStrings {

    public static void main(String[] args) {
        P205_IsomorphicStrings solution = new P205_IsomorphicStrings();
        System.out.println(solution.isIsomorphic("foo", "ads"));
    }

    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        char[] sChar = s.toCharArray();
        int[] sResult = new int[sChar.length];
        char[] tChar = t.toCharArray();
        int[] tResult = new int[tChar.length];
        if (sResult.length != tResult.length) {
            return false;
        }
        for (int i = 0; i < sChar.length; i++) {
           if (sMap.containsKey(sChar[i])) {
               sResult[i] = sMap.get(sChar[i]);
           }
           else {
               sMap.put(sChar[i], i);
               sResult[i] = i;
           }
        }
        for (int i = 0; i < tChar.length; i++) {
            if (tMap.containsKey(tChar[i])) {
                tResult[i] = tMap.get(tChar[i]);
            }
            else {
                tMap.put(tChar[i], i);
                tResult[i] = i;
            }
        }

        for (int i = 0; i < sResult.length; i++) {
            if (sResult[i] != tResult[i]) {
                return false;
            }
        }
        return true;
    }

}
