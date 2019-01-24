package Chapter1.Section3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {

    Node head;
    Node tail;

    private class Node {
        private Item val;
        private Node prev;
        private Node next;
    }

    @Override
    public Iterator<Item> iterator() {
        return new myIterator();
    }

    class myIterator implements Iterator<Item> {

        Node idx = head;

        @Override
        public boolean hasNext() {
            return this.idx!=null;
        }

        @Override
        public Item next() {
            Item rs = idx.val;
            idx = idx.next;
            return rs;
        }
    }


    public Deque() {
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        int num = 0;
        Node idx = head;
        while (idx != null) {
            idx = idx.next;
            num ++;
        }
        return num;
    }

    public void pushLeft(Item item) {
        Node tmp = new Node();
        tmp.val = item;
        tmp.next = head;

        if (isEmpty()) {
            head = tail = tmp;
        } else {
            // 非空
            head.prev = tmp;
            head = tmp;
        }
    }

    public void pushRight(Item item) {
        Node tmp = new Node();
        tmp.val = item;
        tmp.prev = tail;

        if (isEmpty()) {
            head = tail = tmp;
        } else {
            // 非空
            tail.next = tmp;
            tail = tail.next;
        }
    }

    public Item popLeft() {
        if (isEmpty()) {
            return null;
        }
        if (head == tail) {
            Node tmp = head;
            head = tail = null;
            return tmp.val;
        }
        Node tmp = head;
        head = head.next;
        head.prev = null;
        return tmp.val;
    }

    public Item popRight() {
        if (isEmpty()) {
            return null;
        }
        if (head == tail) {
            //只有一个元素
            Node tmp = tail;
            head = tail = null;
            return tmp.val;
        }
        Node tmp = tail;
        tail = tail.prev;
        tail.next = null;
        return tmp.val;
    }

    public static void main(String[] args) {
        Deque<String> q = new Deque<>();
        q.pushLeft("a");
        q.pushLeft("b");
        q.pushLeft("c");
        q.pushLeft("d");
        q.pushLeft("e");
        q.pushLeft("f");
        for(String x: q) {
            StdOut.print(x + "  ");
        }
        StdOut.println();

        q.popRight();
        q.popRight();
        q.popLeft();
        q.popRight();
        q.popRight();
        q.popRight();

        q.pushRight("a");
        q.pushRight("b");
        q.pushRight("c");
        q.pushRight("d");
        q.pushRight("e");
        q.pushRight("f");
        q.pushRight("g");

        q.popRight();
        q.popRight();
        for (String x: q) {
            StdOut.print(x + " ");
        }

        q.popRight();

    }
}
