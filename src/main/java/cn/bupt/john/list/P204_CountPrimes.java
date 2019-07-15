package cn.bupt.john.list;

import java.util.HashSet;
import java.util.Set;

public class P204_CountPrimes {

    public static void main(String[] args) {
        P204_CountPrimes solution = new P204_CountPrimes();
        System.out.println(solution.countPrimes(1500000));
    }

    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }
        int count = 0;
        for (int j = 2; j < n; j++) {
            if (!isEven(j)) {
                count ++;
            }
        }
        return count;
    }

    public boolean isEven(int n) {
        for (int j = 2; j * j<= n; j++) {
           if ( n % j == 0) {
               return true;
           }
        }
        return false;
    }

}
