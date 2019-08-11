package cn.bupt.john.binarytree;

public class P606_ConstructStringFromBinaryTree {

    public static void main(String[] args) {
        P606_ConstructStringFromBinaryTree solution = new P606_ConstructStringFromBinaryTree();
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        System.out.println(solution.tree2str(treeNode));
    }


    public String tree2str(TreeNode t) {
        if (t == null) return "";
        if (t.left == null && t.right == null) return t.val+"";
        if (t.right == null) {
            return t.val+"("+tree2str(t.left)+")";
        }
        return t.val+"("+tree2str(t.left)+")("+tree2str(t.right)+")";
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
