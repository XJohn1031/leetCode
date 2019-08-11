package cn.bupt.john.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P590_N_aryTreePostorderTraversal {

    public static void main(String[] args) {
        P590_N_aryTreePostorderTraversal solution = new P590_N_aryTreePostorderTraversal();
        Node node = new Node(1, Arrays.asList(new Node(2, new ArrayList<>())));
        System.out.println(solution.postorder(node));
    }

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        find(root, result);
        return result;
    }

    private void find(Node root, List<Integer> result) {
        if (root == null) return;
        for (Node child : root.children) {
            find(child, result);
        }
        result.add(root.val);
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
