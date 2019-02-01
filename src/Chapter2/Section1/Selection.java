package Chapter2.Section1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Selection extends Templ{

    public static void sort(Comparable[] a) {
        for (int i=0; i<a.length; i++) {
            int min = i;
            for (int j=i; j<a.length; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }

    public static void main(String[] args) {
        int N;
        N = StdIn.readInt();
        Integer[] a = new Integer[N];
        for (int i=0; i<N; i++) {
            a[i] = StdIn.readInt();
        }
        show(a);
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
