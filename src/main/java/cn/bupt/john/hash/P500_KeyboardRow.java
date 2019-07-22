package cn.bupt.john.hash;

import java.util.Arrays;
import java.util.stream.Stream;

public class P500_KeyboardRow {

    public static void main(String[] args) {
        P500_KeyboardRow solution = new P500_KeyboardRow();
        System.out.println(Arrays.toString(solution.findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"})));
    }

    public String[] findWords(String[] words) {
        return Stream.of(words).filter(data -> data.toLowerCase().matches("[qwertyuiop]+|[asdfghjkl]+|[zxcvbnm]+")).toArray(String[]::new);

    }
}
