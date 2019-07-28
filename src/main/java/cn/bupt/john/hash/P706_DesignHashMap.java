package cn.bupt.john.hash;

import java.util.Objects;

/**
 * 使用数组存储，链表解决冲突。
 * 无扩容
 */
public class P706_DesignHashMap {

    public static void main(String[] args) {
        P706_DesignHashMap hashMap = new P706_DesignHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        hashMap.put(17, 17);
        System.out.println(hashMap.get(1));
        System.out.println(hashMap.get(3));
        hashMap.put(2, 1);
        System.out.println(hashMap.get(2));
        hashMap.remove(2);
        System.out.println(hashMap.get(2));
        System.out.println(hashMap.get(17));
    }

    Node[] data;

    /** value will always be non-negative. */
    public void put(int key, int value) {
        if (data == null) {
            data = new Node[16];
        }
        Node node = new Node();
        node.key = key;
        node.value = value;
        Node datum = data[key % data.length];
        if (datum == null) {
            data[key % data.length] = node;
        }
        else {
            Node temp = data[key % data.length];
            while (temp != null) {
                if (temp.key == key) {
                    temp.value = value;
                    return;
                }
                temp = temp.next;
            }
            node.next = data[key % data.length];
            data[key % data.length] = node;
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if (data == null) {
            return -1;
        }
        Node datum = data[key % data.length];
        while (datum != null) {
            if (datum.key == key) return datum.value;
            datum = datum.next;
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        if (data == null) {
            return;
        }
        Node datum = data[key % data.length];
        if (datum != null && datum.key == key) {
            data[key % data.length] = data[key % data.length].next;
        }
        while (datum != null) {
            if (datum.next != null && datum.next.key == key) {
                datum.next = datum.next.next;
                return;
            }
            datum = datum.next;
        }
    }

    static class Node {
        public int key;
        public int value;
        public Node next;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return key == node.key &&
                    value == node.value ;
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }
}
