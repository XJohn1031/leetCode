package cn.bupt.john.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 解题思路：
 * <p>
 *     遍历candies，结果放入set中，set中为所有糖果种类
 *     <li>如果set大小大于candies.length/2，证明种类大于每人分到的个数，结果为candies.length/2, 否则为set的size</li>
 * </p>
 */
public class P575_DistributeCandies {

    public static void main(String[] args) {
        P575_DistributeCandies solution = new P575_DistributeCandies();
        System.out.println(solution.distributeCandies(new int[]{1,1,2,2,3,3}));
    }

    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < candies.length; i++) {
            set.add(candies[i]);
        }

        return set.size() > candies.length/2 ? candies.length/2 : set.size();
    }
}
