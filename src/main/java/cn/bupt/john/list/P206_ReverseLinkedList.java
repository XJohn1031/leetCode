package cn.bupt.john.list;

public class P206_ReverseLinkedList {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        P206_ReverseLinkedList solution = new P206_ReverseLinkedList();
        ListNode node = solution.reverseList(listNode);
        System.out.println(node);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = findPre(head);
        return pre;
    }

    private ListNode findPre(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode result = findPre(head.next);
        ListNode temp = head.next;
        head.next = null;
        temp.next = head;
        return result;
    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}

