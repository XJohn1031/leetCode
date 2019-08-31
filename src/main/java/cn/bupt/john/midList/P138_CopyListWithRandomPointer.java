package cn.bupt.john.midList;

import java.util.HashMap;
import java.util.Map;

public class P138_CopyListWithRandomPointer {

    public static void main(String[] args) {
        P138_CopyListWithRandomPointer solution = new P138_CopyListWithRandomPointer();
        Node node2 = new Node(2, null, null);
        Node node = new Node(1, node2, node2);
        Node node1 = solution.copyRandomList(node);
        System.out.println(node1
        );
    }

    public Node copyRandomList(Node head) {
        if (head == null) return head;
        Node temp = new Node(0, null, null);
        temp.next = head;
        Map<Node, Node> resultMap = new HashMap<>();
        Node result = new Node(0, null, null);
        Node tempR = result;
        while (temp.next != null) {
            Node node = new Node(temp.next.val, null, temp.next.random);
            tempR.next = node;
            tempR = tempR.next;
            resultMap.put(temp.next, node);
            temp = temp.next;
        }
        temp = result;
        while (temp.next != null) {
            temp.next.random = resultMap.get(temp.next.random);
            temp = temp.next;
        }
        return result.next;
    }

    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
}
