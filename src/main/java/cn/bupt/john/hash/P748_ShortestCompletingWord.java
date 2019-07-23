package cn.bupt.john.hash;

import java.util.ArrayList;
import java.util.List;

public class P748_ShortestCompletingWord {

    public static void main(String[] args) {
       P748_ShortestCompletingWord solution = new P748_ShortestCompletingWord();
        System.out.println(solution.shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"}));
    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        String trim = licensePlate.toLowerCase().trim();
        char[] chars = trim.toCharArray();
        List<Character> plate = new ArrayList<>();
        for (char aChar : chars) {
            if (aChar >= 97 && aChar<= 122) {
                plate.add(aChar);
            }
        }
        int resultL = Integer.MAX_VALUE;
        String result = "";
        for (String word : words) {
            String temp = word;
            for (Character character : plate) {
                temp = temp.replaceFirst(String.valueOf(character), "");
            }
            if (word.length() - temp.length() == plate.size() && resultL > word.length()) {
                result = word;
                resultL = word.length();
            }
        }
        return result;
    }
}
