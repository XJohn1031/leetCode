package cn.bupt.john.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 解题思路
 * <p>
 *     遍历nums1，把其中元素全部放入HashMap，值为出现次数
 *     遍历nums2，如果HashMap中存在，且值>0，则放入result list中。
 * </p>
 */
public class P350_IntersectionOfTwoArraysII {

    public static void main(String[] args) {
        P350_IntersectionOfTwoArraysII solution = new P350_IntersectionOfTwoArraysII();
        System.out.println(Arrays.toString(solution.intersect(new int[]{5}, new int[]{9,4,9,8,4})));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        HashMap<Integer, Integer> firstMap = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
           if (!firstMap.containsKey(nums1[i])) {
               firstMap.put(nums1[i], 1);
           }
           else firstMap.put(nums1[i], firstMap.get(nums1[i]) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            Integer integer = firstMap.get(nums2[i]);
            if (integer == null || integer == 0) {
                continue;
            }
            result.add(nums2[i]);
            firstMap.put(nums2[i], integer - 1);
        }
        int[] ints = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ints[i] = result.get(i);
        }
        return ints;
    }

}
