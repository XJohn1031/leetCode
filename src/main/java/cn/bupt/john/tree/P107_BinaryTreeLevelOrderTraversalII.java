package cn.bupt.john.tree;

import java.util.*;

public class P107_BinaryTreeLevelOrderTraversalII {

    public static void main(String[] args) {
        P107_BinaryTreeLevelOrderTraversalII solution = new P107_BinaryTreeLevelOrderTraversalII();
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(4);
        treeNode.left = treeNode1;
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        System.out.println(solution.levelOrderBottom(treeNode));
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Map<Integer, List<Integer>> resultMap = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        resultMap.put(1, Collections.singletonList(root.val));
        bfs(root.left, root.right, 1, resultMap);
        for (int i = resultMap.size(); i > 0; i--) {
            result.add(resultMap.get(i));
        }
        return result;
    }

    public void bfs(TreeNode left, TreeNode right, int deep, Map<Integer, List<Integer>> resultMap) {
        if (left == null && right == null) {
            return;
        }
        ++deep;
        List<Integer> orDefault = resultMap.getOrDefault(deep, new ArrayList<>());
        if (left == null) {
            orDefault.add(right.val);
            resultMap.put(deep, orDefault);
            bfs(right.left, right.right, deep, resultMap);
            return;
        }
        if (right == null) {
            orDefault.add(left.val);
            resultMap.put(deep, orDefault);
            bfs(left.left, left.right, deep, resultMap);
            return;
        }
        orDefault.add(left.val);
        orDefault.add(right.val);
        resultMap.put(deep, orDefault);
        bfs(left.left, left.right, deep, resultMap);
        bfs(right.left, right.right, deep, resultMap);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
