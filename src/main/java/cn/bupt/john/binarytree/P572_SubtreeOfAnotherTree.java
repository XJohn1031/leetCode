package cn.bupt.john.binarytree;

public class P572_SubtreeOfAnotherTree {

    public static void main(String[] args) {
        P572_SubtreeOfAnotherTree solution = new P572_SubtreeOfAnotherTree();
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        System.out.println(solution.isSubtree(treeNode, treeNode1));
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        boolean sub = isSub(s, t);
        return sub || (isSubtree(s.left, t) || isSubtree(s.right, t));
    }

    public boolean isSub(TreeNode s, TreeNode t) {
        if (t == null && s == null) return true;
        if (t == null || s == null) return false;
        if (t.val == s.val) return isSub(t.left, s.left) && isSub(t.right, s.right);
        return false;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
