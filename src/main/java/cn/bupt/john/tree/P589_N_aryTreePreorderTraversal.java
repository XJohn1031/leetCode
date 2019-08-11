package cn.bupt.john.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P589_N_aryTreePreorderTraversal {

    public static void main(String[] args) {
        P589_N_aryTreePreorderTraversal solution = new P589_N_aryTreePreorderTraversal();
        Node node = new Node(1, Arrays.asList(new Node(2, new ArrayList<>())));
        System.out.println(solution.preorder(node));
    }

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        find(root, result);
        return result;
    }

    private void find(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        for (Node child : root.children) {
            find(child, result);
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
