package cn.bupt.john.midList;


/**
 * 解题思路:
 * <p> 把list分为两部分，前半部分和后半部分，前半部分是需要插入的，后半部分是需要被拆分的</p>
 * <p> 如1-2-3-4， 前半部分是1-2， 后半部分是3-4，后半部分从尾节点往前遍历，前半部分从头结点往后遍历</p>
 * <p> 递归跳出条件：当后半部分遍历到的节点==前半部分遍历到的节点current || current.next</p>
 * <p>
 *     1.维护一个当前节点, 记录需要连接的位置.
 *     2.递归到尾节点, 从尾节点开始拆分并且插入。
 *     3.分析1-2-3-4，4插入的位置是1-2中间，插入完成之后，当前节点变为<li>2</li>.  插入之前当前节点是<li>1</li>.
 *     4.跳出条件：维护一个flag标志，表示不需要递归了。
 * </p>
 */
public class P143_ReorderList {

    public static void main(String[] args) {
        P143_ReorderList solution = new P143_ReorderList();
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        solution.reorderList(listNode);
        System.out.println(listNode);
    }

    private ListNode current = null;
    // 表示已经完成了整个re order 操作。
    private boolean check = false;
    public void reorderList(ListNode head) {
        current = head;
        recursive(head);
    }

    private void recursive(ListNode head) {
        if (head == null) return;
        // 先递归到尾节点, 用递归实现尾节点从前遍历。
        recursive(head.next);
        // 是否已经re order完成
        if (check) {
            return;
        }
        // 判断已经是最后一次re order了。
        if (head == current || current.next == head) {
            check = true;
            head.next = null;
            return;
        }
        // 将尾节点插入
        ListNode temp = current.next;
        current.next = head;
        head.next = temp;
        current = temp;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
