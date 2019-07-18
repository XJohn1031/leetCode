package cn.bupt.john.hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P349_IntersectionOfTwoArrays {

    public static void main(String[] args) {
        P349_IntersectionOfTwoArrays solution = new P349_IntersectionOfTwoArrays();
        System.out.println(Arrays.toString(solution.intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>(nums1.length);
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        int temp = 0;
        Set<Integer> result = new HashSet<>(set.size());
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                result.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }
        Object[] objects = result.toArray();
        int[] x = new int[objects.length];
        for (int i = 0; i < objects.length; i++) {
            x[i] = (int) objects[i];
        }
        return x;
    }
}
