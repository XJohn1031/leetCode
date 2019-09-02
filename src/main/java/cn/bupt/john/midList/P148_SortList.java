package cn.bupt.john.midList;

public class P148_SortList {

    public static void main(String[] args) {
        P148_SortList solution = new P148_SortList();
        ListNode listNode = new ListNode(3);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode4 = new ListNode(4);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode4;
        ListNode listNode3 = solution.sortList(listNode);
        System.out.println(listNode3);
    }

    private ListNode first = new ListNode(0);
    public ListNode sortList(ListNode head) {
        first.next = head;
        while (head != null) {
            // 对每个node都需要进行一次插入, 为了避免node插入之后next节点被修改, 先存下next节点信息
            ListNode temp = head.next;
            // 插入节点
            insert(head);
            // 继续下一个节点的迭代
            head = temp;
        }
        // 返回排好序的list的第二个节点
        return first.next;
    }

    public void insert(ListNode node) {
        // 取第一个节点, 开始遍历
        ListNode temp = first;
        // 如果node就是下一个节点, 那么就将node节点的next节点设置为null
        if (node == temp.next) {
            temp.next.next = null;
            return;
        }
        while (temp.next != null) {
            // 如果node小于排好序的temp节点值, 则node需要插入到temp节点之前
            if(node.val <= temp.next.val) {
                ListNode next = temp.next;
                temp.next = node;
                node.next = next;
                break;
            }
            temp = temp.next;
        }
        // 遍历完排序好的node之后, 证明node是最大的, 需要将它加在排好序的node最后, 并且next节点设置为null
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
