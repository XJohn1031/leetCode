package cn.bupt.john.binarytree;

import java.util.Stack;

public class P965_UnivaluedBinaryTree {

    public static void main(String[] args) {
        P965_UnivaluedBinaryTree solution = new P965_UnivaluedBinaryTree();
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(2);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.right = treeNode4;
        treeNode1.left = treeNode3;
        System.out.println(solution.isUnivalTree(treeNode));
    }

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return false;
        int val = root.val;
        boolean flag = true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty() && flag) {
            TreeNode pop = stack.pop();
            if (pop.val != val) flag = false;
            if (pop.right != null) stack.push(pop.right);
            if (pop.left != null) stack.push(pop.left);
        }
        return flag;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
