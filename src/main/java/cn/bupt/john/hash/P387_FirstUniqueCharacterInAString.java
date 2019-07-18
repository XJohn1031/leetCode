package cn.bupt.john.hash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 解题思路：
 * 1.使用list保存不重复的元素
 * 2.使用set保存已经重复的元素
 * 遍历一遍数组,
 *  <p>
 *      如果set中已经存在，则什么也不做
 *  </p>
 *  <p>
 *      如果set中不存在,
 *      <li>
 *          如果list中存在, 则移除list, 并加入set中
 *      </li>
 *      <li>
 *          如果list中不存在, 则加入list中
 *      </li>
 *
 *  </p>
 *  最后list第一个元素则是第一个不重复元素
 *
 */
public class P387_FirstUniqueCharacterInAString {

    public static void main(String[] args) {
        P387_FirstUniqueCharacterInAString solution = new P387_FirstUniqueCharacterInAString();
        System.out.println(solution.firstUniqChar("aadadaad"));
    }

    public int firstUniqChar(String s) {
        List<Character> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            if (set.contains(chars[i])) {
                continue;
            }
            if (list.contains(chars[i])) {

                list.remove((Character) chars[i]);
                set.add(chars[i]);
            }
            else {
                list.add(chars[i]);
            }
        }
        if (list.isEmpty()) {
            return -1;
        }
        for (int i = 0; i < chars.length; i++) {
            if (list.get(0) == chars[i]) {
                return i;
            }
        }
        return -1;
    }
}
