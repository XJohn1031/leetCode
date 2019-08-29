package cn.bupt.john.midList;

public class P82_RemoveDuplicatesFromSortedListII {

    public static void main(String[] args) {
        P82_RemoveDuplicatesFromSortedListII solution = new P82_RemoveDuplicatesFromSortedListII();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(2);
        ListNode listNode6 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        ListNode listNode = solution.deleteDuplicates(listNode1);
        System.out.println(listNode);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(head.val - 1);
        ListNode result = dummy;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (pre.val != cur.val && cur.val != cur.next.val) {
                result.next = cur;
                result = result.next;
            }
            pre = cur;
            cur = cur.next;
        }
        if (cur.val != pre.val) {
            result.next = cur;
            result = result.next;
        }
        result.next = null;
        return dummy.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
