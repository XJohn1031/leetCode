package cn.bupt.john.binarytree;

import java.util.ArrayList;
import java.util.List;

public class P1022_SumOfRootToLeafBinaryNumbers {

    public static void main(String[] args) {
        P1022_SumOfRootToLeafBinaryNumbers solution = new P1022_SumOfRootToLeafBinaryNumbers();
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(0);
        TreeNode treeNode2 = new TreeNode(0);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(1);
        treeNode.left = treeNode1;
        treeNode1.left = treeNode2;
        treeNode.right = treeNode3;
        treeNode3.right = treeNode4;
        System.out.println(solution.sumRootToLeaf(treeNode));
    }

    List<String> result = new ArrayList<>();
    public int sumRootToLeaf(TreeNode root) {
        find(root, "");
        int re = 0;
        for (String s : result) {
            System.out.println(Integer.decode("0".concat(s)));
        }
        return re;
    }

    private void find(TreeNode root, String cur) {
        if (root == null) return;
        cur = cur.concat(String.valueOf(root.val));
        if (root.left == null && root.right == null) result.add(cur);
        find(root.left, cur);
        find(root.right, cur);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
