package cn.bupt.john.list;

/**
 * LeetCode solution
 *
 */
//public ListNode deleteDuplicates(ListNode head) {
//        ListNode current = head;
//        while (current != null && current.next != null) {
//        if (current.next.val == current.val) {
//        current.next = current.next.next;
//        } else {
//        current = current.next;
//        }
//        }
//        return head;
//        }
public class P083_RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(1);

        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(1);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        P083_RemoveDuplicatesFromSortedList solution = new P083_RemoveDuplicatesFromSortedList();
        solution.deleteDuplicates(listNode);
        System.out.println(listNode);
    }

    public ListNode deleteDuplicates(ListNode head) {
        doIt(head);
        return head;
    }

    private void doIt(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        else {
            while (head.val == head.next.val) {
                head.next = head.next.next;
                if (head.next == null) {
                    break;
                }
            }
            doIt(head.next);
        }
    }


    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
