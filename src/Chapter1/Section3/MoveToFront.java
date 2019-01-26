package Chapter1.Section3;

import edu.princeton.cs.algs4.StdOut;

/**
 * 带头节点的链表实现
 */
public class MoveToFront {
    Node head;

    class Node {
        char val;
        Node next;

        public Node(char val) {
            this.val = val;
            this.next = null;
        }
    }

    public MoveToFront() {
        this.head = new Node('0');
    }

    public void insert(char x) {
        Node tmp = new Node(x);
        tmp.next = head.next;
        head.next = tmp;
    }

    public void delete(char val) {
        Node idx = head;
        while(idx.next != null) {
            if (idx.next.val == val) {
                idx.next = idx.next.next;
            }
            idx = idx.next;
        }
    }

    public void ptlist() {
        Node idx = head.next;
        while(idx != null) {
            StdOut.print(idx.val + "  ");
            idx = idx.next;
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        String cas = "this is";
        MoveToFront t = new MoveToFront();
        for (int i=0; i<cas.length(); i++) {
            char opv = cas.charAt(i);
            t.delete(opv);
            t.insert(opv);
        }
        t.ptlist();
    }
}
