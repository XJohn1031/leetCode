package cn.bupt.john.midList;

public class P92_ReverseLinkedListII {

    public static void main(String[] args) {
        P92_ReverseLinkedListII solution = new P92_ReverseLinkedListII();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        ListNode listNode = solution.reverseBetween(listNode1, 2, 5);
        System.out.println(listNode);
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode temp = result;
        int cur = 1;
        while (cur++ < m) {
            temp = temp.next;
        }
        ListNode next = temp.next;
        temp.next = null;
        ListNode listNode = find(next, n - m + 1);
        temp.next = listNode;
        return result.next;
    }

    private ListNode find(ListNode head, int n) {
        ListNode temp = null;
        ListNode h = head;
        while (n-- > 0) {
            ListNode cur = head.next;
            head.next = temp;
            temp = head;
            head = cur;
        }
        h.next = head;
        return temp;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
