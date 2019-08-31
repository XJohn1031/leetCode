package cn.bupt.john.midList;

public class P109_ConvertSortedListToBinarySearchTree {

    public static void main(String[] args) {
        P109_ConvertSortedListToBinarySearchTree solution = new P109_ConvertSortedListToBinarySearchTree();
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        TreeNode treeNode = solution.sortedListToBST(listNode);
        System.out.println(treeNode);
    }


    public TreeNode sortedListToBST(ListNode head) {
        if (head == null ) return null;
        if (head.next == null) return new TreeNode(head.val);
        if (head.next.next == null) {
            TreeNode treeNode = new TreeNode(head.val);
            TreeNode treeNode1 = new TreeNode(head.next.val);
            treeNode1.left = treeNode;
            return treeNode1;
        }
        ListNode listNode = new ListNode(0);
        listNode.next = head;
        ListNode second = head;
        while (second != null && second.next != null) {
            listNode = listNode.next;
            second = second.next.next;
        }
        ListNode next = listNode.next;
        TreeNode treeNode1 = new TreeNode(next.val);
        listNode.next = null;
        treeNode1.right = sortedListToBST(next.next);
        treeNode1.left = sortedListToBST(head);
        return treeNode1;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
