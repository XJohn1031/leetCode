package cn.bupt.john.binarytree;

public class P530_MinimumAbsoluteDifferenceInBST {

    public static void main(String[] args) {
        P530_MinimumAbsoluteDifferenceInBST solution = new P530_MinimumAbsoluteDifferenceInBST();
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(3);
        treeNode.right = treeNode1;
        treeNode1.left = treeNode2;
        System.out.println(solution.getMinimumDifference(treeNode));
    }

    private int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return -1;
        findNodeMin(root, root.left, true);
        findNodeMin(root, root.right, false);
        getMinimumDifference(root.left);
        getMinimumDifference(root.right);
        return min;
    }

    public void findNodeMin(TreeNode node, TreeNode sub, boolean left) {
        if (sub == null) return;
        if (left) {
            if (sub.right == null) min = Math.min(min, Math.abs(node.val - sub.val));
            else findNodeMin(node, sub.right, left);
        }
        else {
            if (sub.left == null) min = Math.min(min, Math.abs(node.val - sub.val));
            else findNodeMin(node, sub.left, left);
        }
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
