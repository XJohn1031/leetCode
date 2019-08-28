package cn.bupt.john.binarytree;

public class P938_RangeSumOfBST {

    public static void main(String[] args) {
        P938_RangeSumOfBST solution = new P938_RangeSumOfBST();
        TreeNode treeNode = new TreeNode(379);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(826);
        TreeNode treeNode3 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(3);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.right = treeNode4;
        treeNode1.left = treeNode3;
        System.out.println(solution.rangeSumBST(treeNode, 100, 379));
    }

    private int sum = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        find(root, L, R);
        return sum;
    }

    private void find(TreeNode root, int l, int r) {
        if (root == null) return;
        if (root.val <= r && root.val >= l) {
            sum += root.val;
            find(root.left, l, r);
            find(root.right, l, r);
        }
        else if (root.val <= r) {
            find(root.right, l, r);
        }
        else if (root.val >= l) {
            find(root.left, l, r);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
