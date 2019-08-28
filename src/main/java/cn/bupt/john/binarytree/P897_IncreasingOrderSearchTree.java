package cn.bupt.john.binarytree;

import java.util.ArrayList;
import java.util.List;

public class P897_IncreasingOrderSearchTree {

    public static void main(String[] args) {
        P897_IncreasingOrderSearchTree solution = new P897_IncreasingOrderSearchTree();
        TreeNode treeNode = new TreeNode(379);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(826);
        TreeNode treeNode3 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(3);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.right = treeNode4;
        treeNode1.left = treeNode3;
        TreeNode treeNode5 = solution.increasingBST(treeNode);
        System.out.println(treeNode5);
    }

    List<Integer> result = new ArrayList<>();

    public TreeNode increasingBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        increase(root);
        TreeNode pre = new TreeNode(0) , cur = pre;
        for (int i = 0; i < result.size(); i++) {
            cur.right = new TreeNode(result.get(i));
            cur = cur.right;
        }
        return pre.right;
    }

    public void increase(TreeNode root) {
        if (root == null) return;
        increase(root.left);
        result.add(root.val);
        increase(root.right);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
