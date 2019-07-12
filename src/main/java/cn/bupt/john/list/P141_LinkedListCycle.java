package cn.bupt.john.list;

public class P141_LinkedListCycle {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode1;
        P141_LinkedListCycle solution = new P141_LinkedListCycle();
        boolean b = solution.hasCycle(listNode);
        System.out.println(b);
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        return doIt(head, head.next);
    }

    private boolean doIt(ListNode head, ListNode next) {
        if (head == null || head.next == null || next == null || next.next == null) {
            return false;
        }
        if (head.val == next.val) {
            return true;
        }
        return doIt(head.next, next.next.next);
    }


    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
}
