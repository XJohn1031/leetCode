package cn.bupt.john.list;

public class P234_PalindromeLinkedList {

    public static void main(String[] args) {
        P234_PalindromeLinkedList solution = new P234_PalindromeLinkedList();
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(1);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        System.out.println(solution.isPalindrome(listNode));
    }

//    public boolean isPalindrome(ListNode head) {
//        if (head == null || head.next == null) {
//            return true;
//        }
//        ListNode pre = null;
//        ListNode temp = head;
//        while (temp != null) {
//            ListNode listNode = new ListNode(temp.val);
//            listNode.next = pre;
//            pre = listNode;
//            temp = temp.next;
//        }
//        while (head != null) {
//            if (head.val != pre.val) {
//                return false;
//            }
//            head = head.next;
//            pre = pre.next;
//        }
//        return true;
//    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        return doGet(head, head);
    }

    private boolean doGet(ListNode before, ListNode after) {
        boolean result = true;
        if (before.next != null) {
            result = doGet(before.next, after);
        }
        if (!result) {
            return false;
        }
        if (before.val != after.val) {
            return false;
        }
        after = after.next;
        return true;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
