package cn.bupt.john.hash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
