package Chapter1.Section3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Steque<T> {

    private Node head;   // 头指针
    private Node tail;   //尾指针

    private class Node {
        T item;
        Node next;
    }

    public Steque() {}

    public void enque(T item) {

        Node tmp = new Node();
        tmp.item = item;

        if (head == null) {
            head = tmp;
            tail = tmp;
        } else {
            tail.next = tmp;
            tail = tmp;
        }
    }

    public void deque() {
        head = head.next;
    }

    public void push(T item) {
        enque(item);
    }

    public Node pop() {
        Node rs = tail;

        if (head == tail) {
            // 只有0个或1元素
            head = tail = null;
            return rs;
        }

        Node idx = head;
        while (idx.next != tail) {
            idx = idx.next;
        }
        // idx.next = tail
        idx.next = null;
        tail = idx;
        return rs;
    }

    public void print() {
        // 遍历链表
        Node idx = head;
        while (idx != null) {
            StdOut.println(idx.item);
            idx = idx.next;
        }
    }

    public static void main(String[] args) {
        Steque<String> que = new Steque();

        StdOut.println("插入 my name is Jason Peng");
        que.enque("my ");
        que.enque("name ");
        que.push("is ");
        que.push("Jason Peng");
        que.print();
        StdOut.println();

        StdOut.println("执行 pop 操作 ... ");
        que.pop();
        que.print();
        StdOut.println();

        StdOut.println("执行 push Jason");
        que.push("Jason");
        que.print();
        StdOut.println();

        StdOut.println("执行两次deque操作");
        que.deque();
        que.deque();
        que.print();
    }

}
