package cn.bupt.john.hash;

import java.util.*;

public class P884_UncommonWordsFromTwoSentences {

    public static void main(String[] args) {
        P884_UncommonWordsFromTwoSentences solution = new P884_UncommonWordsFromTwoSentences();
        System.out.println(Arrays.toString(solution.uncommonFromSentences("this apple is sweet", "this apple is sour")));
    }

    public String[] uncommonFromSentences(String A, String B) {
        String[] split = A.split(" ");
        String[] split1 = B.split(" ");
        Map<String, Boolean> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (String s : split) {
            if (map.containsKey(s)) {
                map.put(s, false);
            }
            else {
                map.put(s, true);
            }
        }
        for (String s : split1) {
            if (map.containsKey(s)) {
                map.put(s, false);
            }
            else {
                map.put(s, true);
            }
        }
        for (Map.Entry<String, Boolean> entry : map.entrySet()) {
            if (entry.getValue()) {
                result.add(entry.getKey());
            }
        }
        String[] strings = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            strings[i] = result.get(i);
        }
        return strings;
    }
}
