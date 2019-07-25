package cn.bupt.john.hash;

import java.util.HashSet;
import java.util.Set;

public class P771_JewelsAndStones {

    public static void main(String[] args) {
        P771_JewelsAndStones solution = new P771_JewelsAndStones();
        System.out.println(solution.numJewelsInStones("aA", "AaaZZZZZZZZZ"));
    }

    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        char[] chars = J.toCharArray();

        for (char aChar : chars) {
            set.add(aChar);
        }
        char[] sChar = S.toCharArray();
        int count = 0;
        for (char c : sChar) {
            if (set.contains(c)) count++;
        }
        return count;
    }
}
