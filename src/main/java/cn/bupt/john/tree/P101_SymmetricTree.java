package cn.bupt.john.tree;

public class P101_SymmetricTree {

    public static void main(String[] args) {
        P101_SymmetricTree solution = new P101_SymmetricTree();
        System.out.println(solution.isSymmetric(new TreeNode(1)));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return recursive(root.left, root.right);
    }

    public boolean recursive(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        if (l == null || r == null || l.val != r.val) return false;
        return recursive(l.left, r.right) && recursive(l.right, r.left);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
