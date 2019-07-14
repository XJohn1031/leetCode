package cn.bupt.john.list;

public class P160_IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        P160_IntersectionOfTwoLinkedLists solution = new P160_IntersectionOfTwoLinkedLists();
        ListNode listNode5 = new ListNode(1);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode1 = new ListNode(5);
        ListNode listNode = new ListNode(6);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode3.next = listNode2;
        listNode2.next = listNode4;
        listNode5.next = listNode3;
        ListNode node = solution.getIntersectionNode(listNode, listNode5);
        System.out.println(node);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLength = findLength(headA);
        int bLength = findLength(headB);
        if (aLength <= bLength) {
            for (int i = 0; i < bLength-aLength; i++) {
                headB = headB.next;
            }
        }
        else {
            for (int i = 0; i < aLength-bLength; i++) {
                headA = headA.next;
            }
        }
        while (headA != null && headB != null) {
            if(headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    public int findLength(ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
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
