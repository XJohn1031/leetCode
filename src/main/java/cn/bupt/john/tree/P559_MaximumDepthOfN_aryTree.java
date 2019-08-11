package cn.bupt.john.tree;

import java.util.ArrayList;
import java.util.List;

public class P559_MaximumDepthOfN_aryTree {

    public static void main(String[] args) {
        P559_MaximumDepthOfN_aryTree solution = new P559_MaximumDepthOfN_aryTree();
        Node node1 = new Node(2, new ArrayList<>());
        List<Node> list = new ArrayList<>();
        list.add(node1);
        Node node = new Node(1, list);
        System.out.println(solution.maxDepth(node));
    }

    int result = 0;

    public int maxDepth(Node root) {
        return findDeep(root, 0);
    }

    public int findDeep(Node node, int deep) {
        if (node == null) return Math.max(result, deep);
        ++deep;
        for (Node child : node.children) {
            result = Math.max(findDeep(child, deep), result);
        }
        return Math.max(result, deep);
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
