package cn.bupt.john.binarytree;

import java.util.ArrayList;
import java.util.List;

public class P872_Leaf_SimilarTrees {

    public static void main(String[] args) {
        P872_Leaf_SimilarTrees solution = new P872_Leaf_SimilarTrees();
        TreeNode treeNode = new TreeNode(4);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(6);
        TreeNode treeNode3 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(3);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.right = treeNode4;
        treeNode1.left = treeNode3;
        TreeNode treeNode5 = new TreeNode(2);
        TreeNode treeNode6 = new TreeNode(5);
        TreeNode treeNode7 = new TreeNode(1);
        TreeNode treeNode8 = new TreeNode(3);
        TreeNode treeNode9 = new TreeNode(6);
        treeNode5.left = treeNode7;
        treeNode5.right = treeNode6;
        treeNode6.left = treeNode8;
        treeNode6.right = treeNode9;
        System.out.println(solution.leafSimilar(treeNode, treeNode5));
    }

    List<Integer> r1 = new ArrayList<>();
    List<Integer> r2 = new ArrayList<>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        findLeaf(root1, r1);
        findLeaf(root2, r2);
        if (r1.size() != r2.size()) return false;
        for (int i = 0; i < r1.size(); i++) {
            if (r1.get(i) != r2.get(i)) return false;
        }
        return true;
    }

    private void findLeaf(TreeNode node, List<Integer> result) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            result.add(node.val);
        }
        findLeaf(node.left, result);
        findLeaf(node.right, result);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
