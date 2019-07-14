package cn.bupt.john.list;

public class P707_DesignLinkedList {

    private ListNode root;

    private int size = 0;

    public static void main(String[] args) {
        P707_DesignLinkedList solution = new P707_DesignLinkedList();
        solution.addAtHead(1);
        solution.addAtTail(3);
        solution.addAtIndex(1, 2);
        solution.get(1);
        solution.deleteAtIndex(1);
        solution.get(1);
    }


    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (size == 0 || index >= size || index < 0){
            return -1;
        }
        if (index == 0) {
            return root.val;
        }
        ListNode temp = root;
        for (int i = 0; i < index; i++) {
           temp = temp.next;
        }
        return temp.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if (root == null) {
            root = new ListNode(val);
            size++;
            return;
        }
        ListNode node = new ListNode(val);
        node.next = root;
        root = node;
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (root == null) {
            root = new ListNode(val);
            size++;
            return;
        }
        ListNode temp = root;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new ListNode(val);
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        ListNode node = new ListNode(val);
        if (index <= 0) {
            node.next = root;
            root = node;
            size++;
            return;
        }
        ListNode temp = root;
        for (int i = 0; i < index - 1; i++) {
           temp = temp.next;
        }
        if (temp.next == null) {
            temp.next = node;
        }
        else {
            node.next = temp.next;
            temp.next = node;
        }
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= size || size == 0 || index < 0) {
            return;
        }
        if (index == 0) {
            root = root.next;
            size--;
            return;
        }
        ListNode temp = root;
        for (int i = 0; i < index -1; i++) {
           temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
