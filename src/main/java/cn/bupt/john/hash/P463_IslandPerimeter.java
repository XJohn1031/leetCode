package cn.bupt.john.hash;


/**
 *
 * 解题思路1：
 * <p>
 *     <li>需要将矩阵遍历一遍，时间复杂度O(n*m)</li>
 *     <li>当value=1的值与value=1的值相邻时，我们设定一个值为neighbor, 该值代表当前点的相邻个数</li>
 *     <li>在计算neighbor时，我们只需要计算右上两种情况，因为当前元素的左下元素一定被之前元素已经计算过</li>
 *     <li>遍历过程中，当遇到value=1的元素，则使result+1。当右.上存在value=1时，把neighbor值+1</li>
 * </p>
 *
 * 解题思路2：
 * <p>
 *      <li>深度优先遍历</li>
 *      <p>
 *          第一个gird[i][j] = 1的元素, 开始对其做深度优先遍历, 在深度优先遍历过程中，如果遇到gird[i][j] = 1的值时，将其标记为gird[i][j] = -1表示已经遍历过
 *      </p>
 *
 * </p>
 */
public class P463_IslandPerimeter {

    public static void main(String[] args) {
        P463_IslandPerimeter solution = new P463_IslandPerimeter();
        System.out.println(solution.islandPerimeter(new int[][] {{0, 1, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 1, 0, 0}}));
    }

    public int islandPerimeter(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    result += dfs(grid, i, j);
                }
            }
        }
        return result;
    }

    public int dfs(int[][] grid, int i, int j) {
        if (i <0 || j < 0 || i>= grid.length || j>= grid[i].length) {
            return 1;
        }
        if (grid[i][j] == 0) return 1;
        if (grid[i][j] == -1) return 0;

        int count = 0;
        grid[i][j] = -1;

        count += dfs(grid, i-1, j);
        count += dfs(grid, i, j+1);
        count += dfs(grid, i+1, j);
        count += dfs(grid, i, j-1);
        return count;
    }

//    public int islandPerimeter(int[][] grid) {
//        int result = 0;
//        int neibors = 0;
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[i].length; j++) {
//                if (grid[i][j] == 1) {
//                    result ++;
//                    if (i < grid.length -1 && grid[i+1][j] == 1) neibors++;
//                    if (j < grid[i].length -1 && grid[i][j+1] == 1) neibors++;
//                }
//
//            }
//        }
//        return result * 4 - neibors * 2;
//    }
}
