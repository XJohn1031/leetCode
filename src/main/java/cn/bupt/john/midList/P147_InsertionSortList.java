package cn.bupt.john.midList;

public class P147_InsertionSortList {

    public static void main(String[] args) {
        P147_InsertionSortList solution = new P147_InsertionSortList();
        ListNode listNode = new ListNode(3);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode4 = new ListNode(4);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode4;
        ListNode listNode3 = solution.insertionSortList(listNode);
        System.out.println(listNode3);
    }

    private ListNode first = new ListNode(0);
    public ListNode insertionSortList(ListNode head) {
        first.next = head;
        while (head != null) {
            ListNode temp = head.next;
            insert(head);
            head = temp;
        }
        return first.next;
    }

    public void insert(ListNode node) {
        ListNode temp = first;
        if (node == temp.next) {
            temp.next.next = null;
            return;
        }
        while (temp.next != null) {
            if(node.val <= temp.next.val) {
                ListNode next = temp.next;
                temp.next = node;
                node.next = next;
                break;
            }
            temp = temp.next;
        }
        if (temp.next == null) {
            temp.next = node;
            node.next = null;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
