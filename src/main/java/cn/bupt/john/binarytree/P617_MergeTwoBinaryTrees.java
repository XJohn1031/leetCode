package cn.bupt.john.binarytree;

public class P617_MergeTwoBinaryTrees {

    public static void main(String[] args) {
        P617_MergeTwoBinaryTrees solution = new P617_MergeTwoBinaryTrees();
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(5);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        TreeNode node = solution.mergeTrees(treeNode, treeNode4);
        System.out.println(node);
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode node = new TreeNode(t1.val + t2.val);
        node.left = mergeTrees(t1.left, t2.left);
        node.right = mergeTrees(t1.right, t2.right);
        return node;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
