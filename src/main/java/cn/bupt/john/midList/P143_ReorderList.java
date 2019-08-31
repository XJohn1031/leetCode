package cn.bupt.john.midList;


public class P143_ReorderList {

    public static void main(String[] args) {
        P143_ReorderList solution = new P143_ReorderList();
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        solution.reorderList(listNode);
        System.out.println(listNode);
    }

    private ListNode current = null;
    private boolean check = false;
    public void reorderList(ListNode head) {
        current = head;
        recursive(head);
    }

    private void recursive(ListNode head) {
        if (head == null) return;
        recursive(head.next);
        if (check) {
            return;
        }
        if (head == current || current.next == head) {
            check = true;
            head.next = null;
            return;
        }
        ListNode temp = current.next;
        current.next = head;
        head.next = temp;
        current = temp;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
