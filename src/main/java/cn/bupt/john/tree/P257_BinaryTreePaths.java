package cn.bupt.john.tree;

import java.util.ArrayList;
import java.util.List;

public class P257_BinaryTreePaths {

    public static void main(String[] args) {
        P257_BinaryTreePaths solution = new P257_BinaryTreePaths();
        TreeNode treeNode = new TreeNode(1);
        TreeNode t21 = new TreeNode(2);
        TreeNode t22 = new TreeNode(2);
        TreeNode t31 = new TreeNode(3);
        TreeNode t32 = new TreeNode(3);
        TreeNode t33 = new TreeNode(3);
        TreeNode t34 = new TreeNode(3);
        TreeNode t41 = new TreeNode(4);
        TreeNode t42 = new TreeNode(4);
        TreeNode t43 = new TreeNode(4);
        TreeNode t44 = new TreeNode(4);
        TreeNode t45 = new TreeNode(4);
        TreeNode t46 = new TreeNode(4);
        TreeNode t47 = new TreeNode(4);
        TreeNode t48 = new TreeNode(4);
        TreeNode t51 = new TreeNode(5);
        TreeNode t52 = new TreeNode(5);
        treeNode.left = t21;
        treeNode.right = t22;
        t21.left = t31;
        t21.right = t32;
        t22.left = t33;
        t22.right = t34;
        t31.left = t41;
        t31.right = t42;
        t32.left = t43;
        t32.right = t44;
        t33.right = t45;
        t33.left = t46;
        t34.right = t47;
        t34.left = t48;
        t42.right = t51;
        t42.left = t52;
        System.out.println(solution.binaryTreePaths(treeNode));
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        if (root.left == null && root.right == null) {
            result.add(String.valueOf(root.val));
            return result;
        }
        bfs(root.left, String.valueOf(root.val), result);
        bfs(root.right, String.valueOf(root.val), result);
        return result;
    }

    public void bfs(TreeNode node, String temp, List<String> result) {
        if (node == null) {
            return;
        }
        temp = temp.concat("->".concat(String.valueOf(node.val)));
        if (node.left == null && node.right == null) {
            result.add(temp);
            return;
        }
        bfs(node.left, temp, result);
        bfs(node.right, temp, result);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
