package cn.bupt.john.hash;

public class P136_SingleNumber {

    public static void main(String[] args) {
       P136_SingleNumber solution = new P136_SingleNumber();
        System.out.println(solution.singleNumber(new int[] {1, 2, 2, 3, 3}));
    }

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int single = nums[0];
        for (int i = 1; i < nums.length; i++) {
           single = single^nums[i];
        }
        return single;
    }

}
