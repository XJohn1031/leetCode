package cn.bupt.john.hash;

import java.util.*;

public class P1002_FindCommonCharacters {

    public static void main(String[] args) {
        P1002_FindCommonCharacters solution = new P1002_FindCommonCharacters();
        System.out.println(solution.commonChars(new String[]{"bella","label","roller"}));
    }

    public List<String> commonChars(String[] A) {
        Map<Character, Integer> result = new HashMap<>();

        List<Map<Character, Integer>> mapList = new ArrayList<>();
        Set<Character> characters = new HashSet<>(26);
        for (String s : A) {
            Map<Character, Integer> temp = new HashMap<>();
            char[] chars = s.toCharArray();
            for (char aChar : chars) {
                characters.add(aChar);
                temp.put(aChar, temp.getOrDefault(aChar, 0) + 1);
            }
            mapList.add(temp);
        }

        for (Character character : characters) {
            int temp = Integer.MAX_VALUE;
            for (Map<Character, Integer> integerMap : mapList) {
                temp = Math.min(temp, integerMap.getOrDefault(character, 0));
            }
            result.put(character,temp);
        }
        List<String> strings = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : result.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                strings.add(String.valueOf(entry.getKey()));
            }
        }
        return strings;
    }
}
