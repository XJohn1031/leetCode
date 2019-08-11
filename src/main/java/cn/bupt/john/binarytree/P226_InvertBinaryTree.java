package cn.bupt.john.binarytree;

public class P226_InvertBinaryTree {

    public static void main(String[] args) {
        P226_InvertBinaryTree solution = new P226_InvertBinaryTree();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = treeNode1;
        System.out.println(solution.invertTree(treeNode));
        System.out.println(1);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
