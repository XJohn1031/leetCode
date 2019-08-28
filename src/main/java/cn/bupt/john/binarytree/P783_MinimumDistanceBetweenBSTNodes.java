package cn.bupt.john.binarytree;

public class P783_MinimumDistanceBetweenBSTNodes {

    public static void main(String[] args) {
        P783_MinimumDistanceBetweenBSTNodes solution = new P783_MinimumDistanceBetweenBSTNodes();
        TreeNode treeNode = new TreeNode(4);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(6);
        TreeNode treeNode3 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(3);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.right = treeNode4;
        treeNode1.left = treeNode3;
        System.out.println(solution.minDiffInBST(treeNode));
    }

    private int min = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return min;
        }
        if (root.left != null) {
            min = Math.min(min, Math.abs(root.val - root.left.val));
        }
        if (root.right != null) {
            min = Math.min(min, Math.abs(root.val - root.right.val));
        }
        minDiffInBST(root.left);
        minDiffInBST(root.right);
        return min;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
