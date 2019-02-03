package Chapter2.Section1;

import edu.princeton.cs.algs4.StdRandom;

public class Shell extends Templ {

    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N/3) {
            h = 3*h+1;
        }
        while (h > 0) {
            for (int i=h; i<N; i++) {
                for (int j=i; j>=h&&less(a[j],a[j-h]); j-=h) {
                   exch(a, j, j-h);
                }
            }
            h = h/3;
        }
    }

    public static void main(String[] args) {
        int N = StdRandom.uniform(8, 30);
        Double[] a = new Double[N];
        for (int i=0; i<N; i++) {
            a[i] = StdRandom.uniform();
        }
        show(a);
        sort(a);
        show(a);
    }
}
