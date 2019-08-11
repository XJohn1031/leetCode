package cn.bupt.john.binarytree;

public class P235_LowestCommonAncestorOfABinarySearchTree {

    public static void main(String[] args) {
        P235_LowestCommonAncestorOfABinarySearchTree solution = new P235_LowestCommonAncestorOfABinarySearchTree();

        System.out.println();
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val || (p.val < root.val && q.val > root.val) || (p.val > root.val && q.val < root.val)) {
            return root;
        }
        return root.val < p.val? lowestCommonAncestor(root.right, p, q) : lowestCommonAncestor(root.left, p, q);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
