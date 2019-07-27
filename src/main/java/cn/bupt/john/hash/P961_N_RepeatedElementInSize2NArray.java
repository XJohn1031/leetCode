package cn.bupt.john.hash;

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
