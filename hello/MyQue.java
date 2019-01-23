import edu.princeton.cs.algs4.StdOut;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MyQue<T> implements Iterable<T> {

    public class Node implements Iterable {

        int[] arry;
        int pt;
        int it;

        public Node() {
            this.arry = new int[2000];
            this.pt = 0;
            this.it = 0;
        }

        @Override
        public Iterator iterator() {
            return null;
        }

        @Override
        public void forEach(Consumer action) {

        }

        @Override
        public Spliterator spliterator() {
            return null;
        }
    }



    private T[] que;
    private int first;
    private int last;

    public MyQue() {
        this.que = (T[]) new Object[2000];
        this.first = 0;
        this.last = 0;
    }

    public void enque(T item) {
        StdOut.println(item);
        que[last++] = item;
    }

    public void deque() {
        first++;
    }

    public boolean isEmpty() {
        return first==last;
    }

    public int size() {
        return last-first;
    }

    public void aa() {
        StdOut.println(que.getClass());
    }

    public static void main(String[] args) {
        Map a = new HashMap<String, String>();
        MyQue q = new MyQue();

//        MyQue q = new MyQue<Integer>();
//        q.enque("asdfsad");
//        q.enque(2.123);
//        q.deque();
//        if (q.isEmpty()) {
//            StdOut.println("empty");
//        }
//        StdOut.println(q.size());
//        q.aa();
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }
}