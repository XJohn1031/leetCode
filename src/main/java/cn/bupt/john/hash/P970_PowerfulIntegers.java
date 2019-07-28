package cn.bupt.john.hash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 解题思路
 * <p>
 *     在bound范围内，对x，y递增取i，j次方，结果集放入set
 * </p>
 */
public class P970_PowerfulIntegers {

    public static void main(String[] args) {
        P970_PowerfulIntegers solution = new P970_PowerfulIntegers();
        System.out.println(solution.powerfulIntegers(2, 1, 10));
    }

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        int i = 0;
        Set<Integer> result = new HashSet<>();
        while (Math.pow(x, i) < bound) {
            int j =0;
           while (Math.pow(x, i) + Math.pow(y, j) <= bound) {
               result.add((int) (Math.pow(x, i) + Math.pow(y, j)));
               if (y == 1) break;
               j++;
           }
           if (x == 1) break;
           i++;
        }
        return new ArrayList<>(result);
    }
}
