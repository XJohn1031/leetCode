package cn.bupt.john.binarytree;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class P637_AverageOfLevelsInBinaryTree {

    public static void main(String[] args) {
        P637_AverageOfLevelsInBinaryTree solution = new P637_AverageOfLevelsInBinaryTree();
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(9);
        TreeNode treeNode2 = new TreeNode(20);
        TreeNode treeNode3 = new TreeNode(15);
        TreeNode treeNode4 = new TreeNode(7);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
        System.out.println(solution.averageOfLevels(treeNode));
    }

    private Map<Integer, List<Integer>> result = new HashMap<>();

    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) return new ArrayList<>();
        search(root, 1);
        return result.values().stream().map(e -> {
            BigDecimal bigDecimal = new BigDecimal(0);
            for (Integer integer : e) {
                bigDecimal = bigDecimal.add(new BigDecimal(integer));
            }
            return bigDecimal.divide(new BigDecimal(e.size())).doubleValue();
        }).collect(Collectors.toList());
    }

    public void search(TreeNode node, int deep) {
        if (node == null) return;
        List<Integer> orDefault = result.getOrDefault(deep, new ArrayList<>());
        orDefault.add(node.val);
        result.put(deep, orDefault);
        ++deep;
        search(node.left, deep);
        search(node.right, deep);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
