package cn.bupt.john.binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 * 最简单实现：使用递归
 */
public class P653_TwoSumIV_InputIsABST {

    public static void main(String[] args) {
        P653_TwoSumIV_InputIsABST solution = new P653_TwoSumIV_InputIsABST();
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        treeNode.left = treeNode1;
        System.out.println(solution.findTarget(treeNode, 3));
    }

    private Map<Integer, Integer> map = new HashMap<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        return find(root, k);
    }

    public boolean find(TreeNode node, int target) {
        if (node == null) {
            return false;
        }
        if (map.containsKey(target - node.val)) return true;
        map.put(node.val, node.val);
        return find(node.left, target) || find(node.right, target);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
