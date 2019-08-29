package cn.bupt.john.midList;

public class P86_PartitionList {

    public static void main(String[] args) {
        P86_PartitionList solution = new P86_PartitionList();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        ListNode listNode = new ListNode(1);
        ListNode partition = solution.partition(listNode, 0);
        System.out.println(partition);
    }

    public ListNode partition(ListNode head, int x) {
        ListNode first = new ListNode(x + 1);
        first.next = head;
        ListNode temp = first;
        ListNode second = new ListNode(0);
        ListNode tempS = second;
        while (temp.next != null) {
            while (temp.next != null && temp.next.val < x) {
                ListNode node = temp.next;
                temp.next = temp.next.next;
                tempS.next = node;
                tempS = tempS.next;
            }
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        if (second.next != null) {
            tempS.next = first.next;
        }
        else {
            return head;
        }
        return second.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
