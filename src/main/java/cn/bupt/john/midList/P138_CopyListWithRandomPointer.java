package cn.bupt.john.midList;

import java.util.HashMap;
import java.util.Map;

/**
 * 解题思路
 * <p> 借助map来保存old和new节点的映射关系 </p>
 * <p>
 *      1. 首先设置两个dummy节点, 保存old list 和 new list
 *      2. 对old list进行遍历, 生成新list, 并且保存
 *      3. 遍历new list, 替换random节点
 * </p>
 *
 * <leetcode>
 *     <href>https://leetcode.com/problems/copy-list-with-random-pointer/discuss/43491/A-solution-with-constant-space-complexity-O(1)-and-linear-time-complexity-O(N)</href>
 *     不需要其他数据结构存储:
 *     <1> 为每个node增加一个copy node连接在后面</1>
 *     <2> 设置每个copy node 的random node，即指向的random的下一个节点，也就是我们copy的节点</2>
 *     <3> 删除原节点</3>
 * </leetcode>
 */
public class P138_CopyListWithRandomPointer {

    public static void main(String[] args) {
        P138_CopyListWithRandomPointer solution = new P138_CopyListWithRandomPointer();
        Node node2 = new Node(2, null, null);
        Node node = new Node(1, node2, node2);
        Node node1 = solution.copyRandomList(node);
        System.out.println(node1);
    }

    public Node copyRandomList(Node head) {
        if (head == null) return head;
        // 设置一个dummy节点,
        Node temp = new Node(0, null, null);
        temp.next = head;
        Map<Node, Node> resultMap = new HashMap<>();
        // result节点, 放置拷贝的list
        Node result = new Node(0, null, null);
        Node tempR = result;
        // 遍历整个list, 先对每个节点都进行一次copy, 此时不处理random节点, 但是需要将random节点和new节点映射关系存入map
        while (temp.next != null) {
            Node node = new Node(temp.next.val, null, temp.next.random);
            tempR.next = node;
            tempR = tempR.next;
            resultMap.put(temp.next, node);
            temp = temp.next;
        }
        temp = result;
        // 对random进行赋值, 从map中取值
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
