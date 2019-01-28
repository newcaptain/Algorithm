package Chapter1.Section4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class FixedCapaityStack<Item> {

    Item a[];
    int last;

    public FixedCapaityStack(int cap) {
        this.a = (Item[]) new Object[cap];
        this.last = 0;
    }

    public void push(Item val) {
        a[last++] = val;
    }

    public Item pop() {
        return a[--last];
    }

    public static void main(String[] args) {
        for (int N=10000; N<1000000; N+=N) {
            FixedCapaityStack<Integer> tmp = new FixedCapaityStack<>(N);
            int[] t = new int[N];
            for (int i=0; i<N; i++) {
                t[i] = StdRandom.uniform(-19999999, 1999999);
            }
            Stopwatch timer = new Stopwatch();
            // N次push和N次pop操作
            for (int s=0; s<100; s++) {
                for (int i=0; i<N; i++) {
                    tmp.push(t[i]);
                }
                for (int i=0; i<N; i++) {
                    int x = tmp.pop();
                }
            }
            double ed = timer.elapsedTime();
            StdOut.println(N*100 + "\t" + ed + "\t" + N*100/ed);
        }
    }
}
