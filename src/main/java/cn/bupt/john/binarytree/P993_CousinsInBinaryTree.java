package cn.bupt.john.binarytree;

public class P993_CousinsInBinaryTree {

    public static void main(String[] args) {
        P993_CousinsInBinaryTree solution = new P993_CousinsInBinaryTree();
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);
        treeNode.left = treeNode1;
        treeNode1.left = treeNode2;
        treeNode.right = treeNode3;
        treeNode3.right = treeNode4;
        System.out.println(solution.isCousins(treeNode, 3, 5));
    }

    private int xDeep = 0;
    private int yDeep = 0;
    private int xParent;
    private int yParent;

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        find(root.left,0, x, y, root);
        find(root.right, 0, x, y, root);
        return xDeep == yDeep && xDeep != 0 && xParent != yParent;
    }

    public void find(TreeNode node, int deep, int x, int y, TreeNode parent) {
        if (node == null) return;
        if (node.val == x) {
            xDeep = deep;
            xParent = parent.val;
        }
        if (node.val == y) {
            yDeep = deep;
            yParent = parent.val;
        }
        ++deep;
        find(node.left, deep, x, y, node);
        find(node.right, deep, x, y, node);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
