package cn.bupt.john.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 遍历存到map，再遍历map
 */
public class P594_LongestHarmoniousSubsequence {

    public static void main(String[] args) {
        P594_LongestHarmoniousSubsequence solution = new P594_LongestHarmoniousSubsequence();
        System.out.println(solution.findLHS(new int[]{1, 2, 3, 4, 4, 5, 3, 2, 3, 9}));
    }

    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int result = 0;
        for (Integer integer : map.keySet()) {
            if (map.containsKey(integer + 1)) {
                result = Math.max(result, map.get(integer) + map.get(integer + 1));
            }
        }

        return result;
    }
}
