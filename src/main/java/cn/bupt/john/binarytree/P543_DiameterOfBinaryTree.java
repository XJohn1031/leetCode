package cn.bupt.john.binarytree;

public class P543_DiameterOfBinaryTree {

    public static void main(String[] args) {
        P543_DiameterOfBinaryTree solution = new P543_DiameterOfBinaryTree();
        TreeNode treeNode = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(13);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        System.out.println(solution.diameterOfBinaryTree(treeNode));
    }

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return max;
        }

        findHeight(root);
        return max;
    }

    private int findHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = findHeight(node.left);
        int right = findHeight(node.right);

        max = Math.max(left + right, max);
        return Math.max(left, right) + 1;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
