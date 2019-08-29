package cn.bupt.john.midList;

public class P61_RotateList {

    public static void main(String[] args) {
        P61_RotateList solution = new P61_RotateList();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        ListNode listNode3 = solution.rotateRight(listNode1, 2);
        System.out.println(listNode3.val);
    }

    private ListNode last;
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        int n = 1;
        while (cur.next != null) {
            n++;
            cur = cur.next;
        }
        last = cur;
        int result = n - k%n;
        if (result == n) return head;
        cur = head;
        while (result-- > 1) {
            cur = cur.next;
        }
        ListNode re = cur.next;
        cur.next = null;
        last.next = head;
        return re;
    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
}
