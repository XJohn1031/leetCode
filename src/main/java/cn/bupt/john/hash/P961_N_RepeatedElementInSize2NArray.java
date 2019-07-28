package cn.bupt.john.hash;

/**
 * 解题思路
 * <p>
 *     非常精髓的一道题:
 *     对于2n长度的数组，n+1个唯一元素，将这些数组每3个分为一组，必然有多组存在重复, 所以只需要校验这些组内有无重复。
 * </p>
 */
public class P961_N_RepeatedElementInSize2NArray {

    public static void main(String[] args) {
        P961_N_RepeatedElementInSize2NArray solution = new P961_N_RepeatedElementInSize2NArray();
        System.out.println(solution.repeatedNTimes(new int[] {1, 2, 3, 1}));
    }

    public int repeatedNTimes(int[] A) {
        for (int i = 2; i < A.length; i++) {
            if (A[i] == A[i - 1] || A[i] == A[i - 2]) {
                return A[i];
            }
        }
        return A[0];
    }

}
