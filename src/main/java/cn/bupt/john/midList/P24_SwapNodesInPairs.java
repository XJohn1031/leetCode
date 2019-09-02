package cn.bupt.john.midList;


public class P24_SwapNodesInPairs {

    public static void main(String[] args) {
        P24_SwapNodesInPairs solution = new P24_SwapNodesInPairs();
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        ListNode listNode4 = solution.swapPairs(listNode);
        System.out.println(listNode4);
    }

    public ListNode swapPairs(ListNode head) {
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode dummy = first;
        while (dummy.next != null && dummy.next.next != null) {
            ListNode temp = dummy.next.next.next;
            ListNode next = dummy.next;
            dummy.next = dummy.next.next;
            dummy.next.next = next;
            dummy.next.next.next = temp;
            dummy = dummy.next.next;
        }
        return first.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
