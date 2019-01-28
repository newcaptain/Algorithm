package Chapter1.Section4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import javafx.scene.paint.Stop;

public class N38 {
    private static int N;
    private static int[] a;

    public static int threeSum() {
        int cnt = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                for (int k=0; k<N; k++) {
                    if (i < j && j < k) {
                        if (a[i] + a[j] + a[k] == 0) {
                            cnt++;
                        }
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        for (int n=100; n<10000; n+=n) {
            N = n;
            a = new int[n];
            for (int i=0; i<n; i++) {
                a[i] = StdRandom.uniform(-n, n);
            }
            Stopwatch timer = new Stopwatch();
            threeSum();
            double ed = timer.elapsedTime();
            StdOut.println(N + "\t" + ed);
        }
    }
}
