package Chapter1.Section3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Queue;

public class Josephus {
    int[] array;
    int last;

    public Josephus() {
        this.array = new int[1];
        last = 0;
    }

    public boolean isEmpty() {
        return last==0;
    }

    public void resize(int l) {
        int[] tmp = new int[l];
        for (int i=0; i<last; i++) {
            tmp[i] = array[i];
        }
        array = tmp;
    }

    public void enque(int val) {
        if (last == array.length) {
            resize(2*array.length);
        }
        array[last++] = val;
    }

    public int deque() {
        int rs = array[0];
        for (int i=1; i<last; i++) {
            array[i-1] = array[i];
        }
        last--;
        StdOut.println("\nlast: " + last + "\tlength: " + array.length);
        if (last > 0 && last == array.length/4) {
            resize(array.length/2);
        }
        return rs;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int M = Integer.parseInt(args[1]);

        Josephus js = new Josephus();
        for (int i=0; i<N; i++) {
            js.enque(i);
        }
        while(!js.isEmpty()) {
            for (int i=1; i<M; i++) {
                js.enque(js.deque());
            }
            StdOut.print(js.deque() + " ");
        }
        StdOut.println();
    }
}
