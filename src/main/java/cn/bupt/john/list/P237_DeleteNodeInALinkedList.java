package cn.bupt.john.list;

public class P237_DeleteNodeInALinkedList {

    public static void main(String[] args) {
        P237_DeleteNodeInALinkedList solution = new P237_DeleteNodeInALinkedList();

        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        solution.deleteNode(listNode1);
        System.out.println(listNode);
    }

    public void deleteNode(ListNode node) {
        if (node.next == null) {
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
