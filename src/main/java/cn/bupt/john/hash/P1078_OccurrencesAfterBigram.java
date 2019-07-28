package cn.bupt.john.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * so foolish
 */
public class P1078_OccurrencesAfterBigram {

    public static void main(String[] args) {
        P1078_OccurrencesAfterBigram solution = new P1078_OccurrencesAfterBigram();
        System.out.println(Arrays.toString(solution.findOcurrences("alice is a good girl she is a good student", "a", "good")));
    }

    public String[] findOcurrences(String text, String first, String second) {
        String[] split = text.split(" ");
        List<String> result = new ArrayList<>();
        for (int i = 0; i < split.length -2; i++) {
            if (split[i].equals(first) && split[i + 1].equals(second)) {
                result.add(split[i + 2]);
            }
        }
        String[] strings = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            strings[i] = result.get(i);
        }
        return strings;
    }
}
