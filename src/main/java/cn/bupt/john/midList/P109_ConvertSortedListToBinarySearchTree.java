package cn.bupt.john.midList;

/**
 * 解题思路:
 * <p>
 *     使用动态规划法
 *     <1> 先通过双指针方法找到中间节点</1>
 *     <2> 递归地把中间节点左边的和右边的节点构造成树</2>
 *     <attention> 此处要注意：
 *          <a> 需要将list分开, 即左边的list最后一个节点要断开</a>
 *          <b> 设置一个dummy头结点来位移, 使得取到中间节点的前一个节点</b>
 *     </attention>
 *     <3> 递归跳出条件
 *          <a> 只有两个节点, 构造一个树返回</a>
 *          <b> 只有一个节点</b>
 *     </3>
 * </p>
 */
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
        // 如果只有两个节点, 直接构造这个tree
        if (head.next.next == null) {
            TreeNode treeNode = new TreeNode(head.val);
            TreeNode treeNode1 = new TreeNode(head.next.val);
            treeNode1.left = treeNode;
            return treeNode1;
        }
        // 如果不是两个节点, 则需要构造子tree
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
