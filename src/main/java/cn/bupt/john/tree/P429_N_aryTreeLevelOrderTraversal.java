package cn.bupt.john.tree;

import java.util.*;

public class P429_N_aryTreeLevelOrderTraversal {

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(Node root) {
        Map<Integer, List<Integer>> result = new HashMap<>();
        if (root == null) {
            return new ArrayList<>();
        }
        result.put(1, Arrays.asList(root.val));
        find(root, result, 2);
        List<List<Integer>> c = new ArrayList<>();
        c.addAll(result.values());
        return c;
    }

    private void find(Node root, Map<Integer, List<Integer>> result, int deep) {
        if (root == null) return;
        List<Integer> temp = new ArrayList<>();
        for (Node child : root.children) {
            temp.add(child.val);
        }
        if (!temp.isEmpty()){
            List<Integer> orDefault = result.getOrDefault(deep, new ArrayList<>());
            orDefault.addAll(temp);
            result.put(deep, orDefault);
        }
        ++deep;
        for (Node child : root.children) {
            find(child, result, deep);
        }
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
