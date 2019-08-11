package cn.bupt.john.binarytree;

import java.util.ArrayList;
import java.util.List;

public class P112_PathSum {

    public static void main(String[] args) {
        P112_PathSum solution = new P112_PathSum();
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);
        treeNode.left = treeNode1;
        System.out.println(solution.hasPathSum(treeNode, 1));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return false;
        }
        dfs(root, 0, result);
        return result.contains(sum);
    }

    public void dfs(TreeNode node, int temp, List<Integer> result) {
        if (node == null) {
            return;
        }
        temp += node.val;
        if (node.left == null && node.right == null) {
            result.add(temp);
            return;
        }
        dfs(node.left, temp, result);
        dfs(node.right, temp, result);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
