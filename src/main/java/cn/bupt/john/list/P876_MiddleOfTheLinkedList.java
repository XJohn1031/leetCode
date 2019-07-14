package cn.bupt.john.list;

public class P876_MiddleOfTheLinkedList {

    public static void main(String[] args) {
        P876_MiddleOfTheLinkedList solution = new P876_MiddleOfTheLinkedList();
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        ListNode node = solution.middleNode(listNode);
        System.out.println(node);
    }

    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        ListNode temp = head;
        while (true) {
           current = current.next.next;
           temp = temp.next;
           if (current == null || current.next == null) {
               return temp;
           }
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
