package cn.bupt.john.hash;

import java.util.Objects;

/**
 * 使用数组存储，链表解决冲突
 * 无扩容
 */
public class P705_DesignHashSet {

    public static void main(String[] args) {
        P705_DesignHashSet hashSet = new P705_DesignHashSet();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1));
        System.out.println(hashSet.contains(3));
        hashSet.add(2);
        System.out.println(hashSet.contains(2));
        hashSet.remove(2);
        System.out.println(hashSet.contains(2));
    }

    Node[] data;

    public void add(int key) {
        if (data == null) {
            data = new Node[10000];
        }
        Node datum = data[key % data.length];
        while (datum != null) {
            if (datum.key == key) return;
            datum = datum.next;
        }
        Node node = new Node();
        node.key = key;
        node.next = data[key % data.length];
        data[key % data.length] = node;
    }

    public void remove(int key) {
        if (data == null) {
            return;
        }
        Node datum = data[key % data.length];
        if (datum != null && datum.key == key) {
            data[key % data.length] = data[key % data.length].next;
            return;
        }
        while (datum != null) {
            if (datum.next != null && datum.key == key) {
                datum.next = datum.next.next;
                return;
            }
            datum = datum.next;
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if (data == null) {
            return false;
        }
        Node datum = data[key % data.length];
        while (datum != null) {
            if (datum.key == key) return true;
            datum = datum.next;
        }
        return false;
    }

    static class Node {
        public int key;
        public Node next;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return key == node.key;
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }
    }
}
