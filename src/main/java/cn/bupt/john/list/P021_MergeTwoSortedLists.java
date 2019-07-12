package cn.bupt.john.list;

public class P021_MergeTwoSortedLists {

    public static void main(String[] args) {
        P021_MergeTwoSortedLists solution = new P021_MergeTwoSortedLists();
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(1);

        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(4);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode listNode6 = solution.mergeTwoLists(listNode, listNode3);
        System.out.println(listNode6);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result;
        if (l1 == null) {
            result = l2;
            return result;
        }
        else if (l2 == null) {
            result = l1;
            return result;
        }
        if (l1.val <= l2.val) {
            result = new ListNode(l1.val);
            l1 = l1.next;
        }
        else {
            result = new ListNode(l2.val);
            l2 = l2.next;
        }
        doIt(l1, l2, result);

        return result;
    }

    private ListNode doIt(ListNode l1, ListNode l2, ListNode current) {
        if (l1 != null && l2 !=null) {
        ListNode temp = new ListNode(0);
            if (l1.val <= l2.val) {
                temp.val = l1.val;
                l1 = l1.next;
            }
            else {
                temp.val = l2.val;
                l2 = l2.next;
            }
            current.next = temp;
            return doIt(l1, l2, temp);
        }
        else if (l1 == null) {
            current.next = l2;
        }
        else {
            current.next = l1;
        }
        return current;
    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
