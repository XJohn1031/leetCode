package cn.bupt.john.binarytree;

import java.util.Arrays;

public class P108_ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        P108_ConvertSortedArrayToBinarySearchTree solution = new P108_ConvertSortedArrayToBinarySearchTree();
        TreeNode treeNode = solution.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(treeNode.val);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) {
            return null;
        }
        return build(nums);
    }

    private TreeNode build(int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        if (arr.length == 1) {
           return new TreeNode(arr[0]);
        }
        if (arr.length == 2) {
            TreeNode treeNode = new TreeNode(arr[1]);
            TreeNode l = new TreeNode(arr[0]);
            treeNode.left = l;
            return treeNode;
        }
        TreeNode treeNode = new TreeNode(arr[arr.length / 2]);
        treeNode.left = build(Arrays.copyOfRange(arr, 0, arr.length/2));
        treeNode.right = build(Arrays.copyOfRange(arr, arr.length/2 +1, arr.length));
        return treeNode;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
