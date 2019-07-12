package cn.bupt.john.list;

public class P142_LinkedListCycleII {


    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        return getNode(head);
    }

    public ListNode getNode(ListNode head) {
        int length = getLength(head, head.next, 0);
        if (length == -1) {
            return null;
        }
        ListNode tempNode = head;
        for (int i = 0; i<length; i++) {
            tempNode = tempNode.next;
        }
        return doGet(head, tempNode);
    }

    public int getLength(ListNode head, ListNode next, int temp) {
        if (head == null || head.next == null || next == null || next.next == null) {
            return -1;
        }
        if (head.val == next.val) {
            return temp;
        }
        temp +=1;

        return getLength(head.next, next.next.next, temp);
    }
    public ListNode doGet(ListNode head, ListNode tempNode){
        if (head == tempNode.next) {
            return head;
        }
        return doGet(head.next, tempNode.next);
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
