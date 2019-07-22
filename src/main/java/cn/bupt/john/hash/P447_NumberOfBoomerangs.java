package cn.bupt.john.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 解题思路：
 * <p>
 *     回旋镖需要(i, j, k)三个点
 *     <li>选定一个基准点，计算其他点与该基准点的距离并且存入map，value为该距离出现次数</li>
 *     <li>每次基准点遍历完成之后，将map中的value做 value * (value -1) 操作， 也就是C(n, 2)操作 C(n, 2) = n * (n -1)</li>
 * </p>
 */
public class P447_NumberOfBoomerangs {

    public static void main(String[] args) {
        P447_NumberOfBoomerangs solution = new P447_NumberOfBoomerangs();
        System.out.println(solution.numberOfBoomerangs(new int[][] {{1,0}, {2,0}, {0,0}}));
    }

    public int numberOfBoomerangs(int[][] points) {
        int result = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {

            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                int distance = distance(points[i], points[j]);
                map.put(distance, map.getOrDefault(distance, 0) + 1);
            }

            for (Integer integer : map.values()) {
                result += integer * (integer - 1);
            }
            map.clear();
        }
        return result;
    }

    public int distance(int[] x, int[] y) {
        int l1 = x[0] - y[0];
        int l2 = x[1] - y[1];
        return l1 * l1 + l2 * l2;
    }
}
