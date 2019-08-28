package cn.bupt.john.binarytree;

public class P700_SearchInABinarySearchTree {

    public static void main(String[] args) {
        P700_SearchInABinarySearchTree solution = new P700_SearchInABinarySearchTree();
        TreeNode treeNode = new TreeNode(4);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(6);
        TreeNode treeNode3 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(3);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.right = treeNode4;
        treeNode1.left = treeNode3;
        TreeNode treeNode5 = solution.searchBST(treeNode, 1);
        System.out.println(treeNode5);
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val < val) {
            return searchBST(root.right, val);
        }
        else if (root.val > val) {
            return searchBST(root.left, val);
        }
        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
