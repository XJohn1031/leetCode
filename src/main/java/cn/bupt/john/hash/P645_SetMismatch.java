package cn.bupt.john.hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 我的方法：
 * 遍历求和，求和结果减去(1+n)n/2,求和公式 = x -y 。x为重复值，y为丢失值
 * 使用set找出重复值。
 *
 * 更优解法：
 * 对每个i, 设置 nums[nums[i] -1] *= -1, 也就是重复的值再次设置时，已经为-1，这里使用O(1)的空间复杂度求出了重复值
 * 最后使用求和公式找出丢失值
 *
 * xor：异或比较
 */
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
