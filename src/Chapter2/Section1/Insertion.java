package Chapter2.Section1;

import edu.princeton.cs.algs4.StdIn;

public class Insertion extends Templ{

    public static void sort(Comparable[] a) {
        for (int i=1; i<a.length; i++) {
            for (int j=i; j>0 && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
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
        show(a);
    }
}
