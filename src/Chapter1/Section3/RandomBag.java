package Chapter1.Section3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomBag<Item> implements Iterable<Item> {

    Item[] array;
    int N;

    public RandomBag() {
        array = (Item[])new Object[1];
        N = 0;
    }

    public boolean isEmpty() {
        return N==0;
    }

    public int size() {
        return N;
    }

    public void add(Item item) {
        if (size() == array.length) {
            Item[] tmp = (Item[])new Object[2*array.length];
            for (int i=0; i<N; i++) {
                tmp[i] = array[i];
            }
            array = tmp;
        }
        array[N++] = item;
    }

    public static void main(String[] args) {
        RandomBag<String> rb = new RandomBag<>();

        rb.add("my");
        rb.add("name");
        rb.add("is");
        rb.add("a");
        rb.add("codding");

        for(String x: rb) {
            StdOut.println(x);
        }


    }

    @Override
    public Iterator<Item> iterator() {
        return new myIterator();
    }

    class myIterator implements Iterator<Item> {

        int idx;

        public myIterator() {
            StdRandom.shuffle(array,0, N);
        }

        @Override
        public boolean hasNext() {
            return idx < N;
        }

        @Override
        public Item next() {
            Item rs = array[idx];
            idx ++;
            return rs;
        }
    }
}
