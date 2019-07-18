package cn.bupt.john.hash;

import java.util.HashSet;

public class P217_ContainsDuplicate {

    public static void main(String[] args) {
        P217_ContainsDuplicate solution = new P217_ContainsDuplicate();
        System.out.println(solution.containsDuplicate(new int[]{1, 2, 2}));
    }

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            else {
                set.add(nums[i]);
            }
        }
        return false;
    }
}
