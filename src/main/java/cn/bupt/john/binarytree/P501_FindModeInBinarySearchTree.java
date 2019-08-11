package cn.bupt.john.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P501_FindModeInBinarySearchTree {

    public static void main(String[] args) {
        P501_FindModeInBinarySearchTree solution = new P501_FindModeInBinarySearchTree();
        TreeNode treeNode = new TreeNode(6);
        TreeNode t21 = new TreeNode(2);
        TreeNode t22 = new TreeNode(8);
        TreeNode t31 = new TreeNode(0);
        TreeNode t32 = new TreeNode(4);
        TreeNode t33 = new TreeNode(7);
        TreeNode t34 = new TreeNode(9);
        TreeNode t41 = new TreeNode(2);
        TreeNode t42 = new TreeNode(6);
        treeNode.left = t21;
        treeNode.right = t22;
        t21.left = t31;
        t21.right = t32;
        t22.left = t33;
        t22.right = t34;
        t32.left = t41;
        t32.right = t42;
        System.out.println(Arrays.toString(solution.findMode(treeNode)));
    }

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        if (root.left == null && root.right == null) {
            return new int[]{root.val};
        }
        List<Integer> result = new ArrayList<>();
        findResult(root, root, 0, result);
        int[] re = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            re[i] = result.get(i);
        }
        return re;
    }

    public void findResult(TreeNode root, TreeNode node, int max, List<Integer> result) {
        if (node == null) {
            return;
        }
        if (!result.contains(node.val)) {
            int sum = getSum(root, node.val);
            if (sum == max) {
                result.add(node.val);
            }
            if (sum > max) {
                result.clear();
                result.add(node.val);
                max = sum;
            }
        }

        findResult(root, node.left, max, result);
        findResult(root, node.right, max, result);
    }

    private int getSum(TreeNode node, int val) {
        int count = 0;
        if (node == null) {
            return count;
        }
        if (node.val == val) {
            ++count;
        }
        count+=getSum(node.left, val);
        count+=getSum(node.right, val);
        return count;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
