package Chapter1.Section3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomQueue<Item> implements Iterable<Item>{
    Item[] array;
    int N;

    public RandomQueue() {
        array = (Item[])new Object[1];
        N = 0;
    }

    boolean isEmpty() {
        return N == 0;
    }

    void resize(int l) {
        Item[] x = (Item[]) new Object[l];
        for (int i=0; i<N; i++) {
            x[i] = array[i];
        }
        array = x;
    }

    void enqueue(Item item) {
        if (N == array.length) {
            resize(2*array.length);
        }
        array[N++] = item;
    }

    Item dequeue() {
        int idx = StdRandom.uniform(0, N);
        Item rs = array[idx];
        for (int i=idx+1; i<N; i++) {
            array[i-1] = array[i];
        }
        N--;
        array[N] = null;
        if (N > 0 && N == array.length/4) {
            resize(array.length/2);
        }
        return rs;
    }

    Item sample() {
        int idx = StdRandom.uniform(0, N);
        return array[idx];
    }

    public static void main(String[] args) {
        RandomQueue<String> tst = new RandomQueue<>();
        tst.enqueue("A");
        tst.enqueue("2");
        tst.enqueue("3");
        tst.enqueue("4");
        tst.enqueue("5");
        tst.enqueue("6");
        tst.enqueue("7");
        tst.enqueue("8");
        tst.enqueue("k");

        for (String t: tst) {
            StdOut.print(t + " ");
        }
        StdOut.println();

        for (int i=0; i<5; i++) {
            StdOut.print(tst.dequeue() + " ");
        }
        StdOut.println();

        for (String s: tst) {
            StdOut.print(s + " ");
        }
        StdOut.println();
    }

    @Override
    public Iterator<Item> iterator() {
        return new arrayIterator();
    }

    class arrayIterator implements Iterator<Item>{

        int it;

        public arrayIterator() {
            it = 0;
            StdRandom.shuffle(array,0, N);
        }

        @Override
        public boolean hasNext() {
            return it<N;
        }

        @Override
        public Item next() {
            Item rs = array[it];
            it++;
            return rs;
        }
    }
}
