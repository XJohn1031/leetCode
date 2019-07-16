package cn.bupt.john.list;

/**
 * 使用滑动窗口
 */
public class P219_ContainsDuplicateII {

    public static void main(String[] args) {
        P219_ContainsDuplicateII solution = new P219_ContainsDuplicateII();
        System.out.println(solution.containsNearbyDuplicate(new int[]{99,99}, 2));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= i + k && j <nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
