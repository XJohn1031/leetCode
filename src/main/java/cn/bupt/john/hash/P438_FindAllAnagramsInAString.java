package cn.bupt.john.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 解题思路
 * <p>
 *     使用滑动窗口。
 *     设置滑动值begin，end end一直滑动，知道出现满足值，然后开始滑动begin
 *     维护一个计数器counter，用来表示是否完全匹配。
 *     <li>第一步。将匹配p所有字符放入map中，值为字符出现次数</li>
 *     <li>第二步。使用end开始滑动待匹配s，如果出现map中的字符，则将map中的值-1</li>
 *     <p>
 *         每当map中对应的value减到0时，将计数器-1
 *     </p>
 *     <p>
 *         当计数器的值变为0时，说明匹配值找到了。此时进入第二个循环，进入第二个循环时end -begin >=0, 此时还需要继续滑动begin。
 *     </p>
 *     <p>
 *         滑动begin过程中，如果出现了map中存在的元素，需要将滑过的字符在map中value+1，当对应的value>0时，说明此时已经不满足匹配结果，counter+1.
 *         <li>当end-begin的值 == p.length时，说明此时匹配成功，result+1</li>
 *     </p>
 * </p>
 */
public class P438_FindAllAnagramsInAString {

    public static void main(String[] args) {
        P438_FindAllAnagramsInAString solution = new P438_FindAllAnagramsInAString();
        System.out.println(solution.findAnagrams("cbeaebabacd", "abc"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        // 滑动窗口
        // begin 为当前滑动初始位置, end 为符合滑动条件的末位
        int begin = 0,end = 0;
        char[] chars = p.toCharArray();

        // 存储需要滑动的字符集合, value为字符的个数
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
        }

        // 保持一个计数器, 用来判断滑动过程中是否有满足条件的集合
        int counter = map.size();
        List<Integer> list = new ArrayList<>();
        // 开始遍历 s
        while (end < s.length()) {

            char c = s.charAt(end);
            // 如果遍历过程中, 遍历到的c 存在于 p中, 则将map中c 对应的value -1, 当减之后的值变为0时, 说明该值已经匹配了p中所有该元素的值, 将计数器减1
            // 此时需要注意, 当某个元素出发counter - 1 时, 如果再次遇到该元素, 应该继续减, 且map中对应的value也会减为负数
            if (map.containsKey(c)) {
                Integer result = map.get(c);
                map.put(c,  result - 1);
                if (result == 1) {
                    counter -- ;
                }
            }

            end ++ ;
            // 只有当找到符合条件的字符序列集合时才开始滑动, 但是此时begin和end的差值 > p 的长度, 所以需要从begin一直滑动
            while (counter == 0) {
                char b = s.charAt(begin);
                // 滑动过程中需要不断地将滑动过的元素与p中元素进行匹配，如果匹配成功，需要在map中加上之前end滑动过程中减去的元素，当map中该元素的值大于0时，
                // 已经不满足匹配条件，跳出滑动。
                if (map.containsKey(b)) {
                    map.put(b, map.get(b) + 1);
                    if (map.get(b) > 0) counter ++;
                }

                // 当满足该条件时，证明匹配到了该字符串
                if (end - begin == p.length()) {
                    list.add(begin);
                }
                begin ++;
            }
        }

        return list;
    }
}
