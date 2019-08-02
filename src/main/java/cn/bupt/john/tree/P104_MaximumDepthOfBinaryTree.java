package cn.bupt.john.tree;

public class P104_MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        P104_MaximumDepthOfBinaryTree solution = new P104_MaximumDepthOfBinaryTree();
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(4);
        treeNode.left = treeNode1;
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        System.out.println(solution.maxDepth(treeNode3));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return deep(root.left, root.right, 1);
    }

    public int deep(TreeNode left, TreeNode right, int deep) {
        if (left == null && right == null) {
            return deep;
        }
        if (left == null) {
            return deep(right.left, right.right, ++deep);
        }
        if (right == null) {
            return deep(left.left, left.right, ++deep);
        }
        return Math.max(deep(left.left, left.right, deep + 1), deep(right.left, right.right, deep + 1));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
