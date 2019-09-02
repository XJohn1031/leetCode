package cn.bupt.john.midList;

public class P19_RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        P19_RemoveNthNodeFromEndOfList solution = new P19_RemoveNthNodeFromEndOfList();
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        ListNode listNode5 = solution.removeNthFromEnd(listNode, 1);
        System.out.println(listNode5);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (--n > 0) {
            head = head.next;
        }
        ListNode cur = dummy;
        while (head.next != null) {
            cur = cur.next;
            head = head.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
