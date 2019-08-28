package cn.bupt.john.binarytree;

public class P671_SecondMinimumNodeInABinaryTree {

    public static void main(String[] args) {
        P671_SecondMinimumNodeInABinaryTree solution = new P671_SecondMinimumNodeInABinaryTree();
        TreeNode treeNode = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(7);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        System.out.println(solution.findSecondMinimumValue(treeNode));
    }

    private int first = Integer.MAX_VALUE;

    private int second = Integer.MAX_VALUE;

    private boolean flag = false;

    public int findSecondMinimumValue(TreeNode root) {
        find(root);
        return flag ? second : -1;
    }

    private void find(TreeNode root) {
        if (root == null) return;
        if (root.val < first) {
            second = first;
            first = root.val;
        }
        else if (root.val <= second && root.val != first) {
            flag = true;
            second = root.val;
        }
        find(root.left);
        find(root.right);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
