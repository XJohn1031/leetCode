package cn.bupt.john.list;

public class P203_RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        while (head.val == val) {
            head = head.next;
            if (head == null) {
                return head;
            }
        }
        fixAfter(head, val);
        return head;
    }

    private void fixAfter(ListNode head, int val) {
        if (head == null || head.next == null) {
            return;
        }
        if (head.next.val == val) {
            head.next = head.next.next;
            fixAfter(head, val);
        }
        fixAfter(head.next, val);
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
