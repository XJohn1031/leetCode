package cn.bupt.john.binarytree;

public class P538_ConvertBSTToGreaterTree {

    public static void main(String[] args) {
        P538_ConvertBSTToGreaterTree solution = new P538_ConvertBSTToGreaterTree();
        TreeNode treeNode = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(13);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        System.out.println(solution.convertBST(treeNode));
        System.out.println("yes");
    }

    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        getsum(root);
        inorder(root);
        return root;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        int temp = node.val;
        node.val = sum;
        sum -= temp;
        inorder(node.right);
    }

    private void getsum(TreeNode root) {
        if (root == null) return;
        sum += root.val;
        getsum(root.left);
        getsum(root.right);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
