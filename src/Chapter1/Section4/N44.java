package Chapter1.Section4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class N44 {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int[] a = new int[N];
        int i;
        int s = 5;
        while (s-- != 0) {

            for (int j=0; j<N; j++) {
                a[j] = 0;
            }

            for (i=0; true; i++) {
                int t = StdRandom.uniform(N);
                if (a[t] == 0) {
                    a[t] = 1;
                } else {
                    break;
                }
            }
            StdOut.println(i);
        }
    }
}
