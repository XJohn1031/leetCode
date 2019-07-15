package cn.bupt.john.list;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class P202_HappyNumber {

    public static void main(String[] args) {
        P202_HappyNumber solution = new P202_HappyNumber();
        System.out.println(solution.isHappy(10000));
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int result = getResult(n);
        while (result != 1) {
            if (set.contains(result)) {
                return false;
            }
            set.add(result);
            result = getResult(result);
        }
        return true;
    }

    public int getResult(int n) {
        int res = n;
        int es = 0;
        int sum = 0;
        while (res > 0) {
            es = res % 10;
            sum += es * es;
            res = res / 10;
        }
        return sum;
    }

}
