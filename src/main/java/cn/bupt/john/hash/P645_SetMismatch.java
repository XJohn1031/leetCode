package cn.bupt.john.hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P645_SetMismatch {

    public static void main(String[] args) {
        P645_SetMismatch solution = new P645_SetMismatch();
        System.out.println(Arrays.toString(solution.findErrorNums(new int[]{1, 2, 3, 5, 6, 7, 8, 8, 9})));
    }

    public int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int temp = 0;
        int all = 0;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                temp = nums[i];
            }
            else {
                set.add(nums[i]);
            }
            all += nums[i];
        }
        int result = (1 + nums.length)*(nums.length)/2;
        int val = temp - (all - result);
        return new int[]{temp, val};
    }
}
