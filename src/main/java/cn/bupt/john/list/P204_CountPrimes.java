package cn.bupt.john.list;


public class P204_CountPrimes {

    public static void main(String[] args) {
        P204_CountPrimes solution = new P204_CountPrimes();
        System.out.println(solution.countPrimes(100));
    }

    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }
        boolean[] result = new boolean[n];
        int count = 0;
        for (int j = 2; j < n; j++) {
            if (!result[j]) count++;
            for (int i = 0; i * j< n; i++) {
               result[i*j] = true;
            }
        }

        return count;
    }

}
