package Chapter1.Section4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * 最接近的一对
 */
public class N16 {
    public static void main(String[] args) {

        int N = 10;
        double a[] = new double[N];

        for (int i=0; i<N; i++) {
            a[i] = StdRandom.uniform(-10.0, 10.0);
        }

        for (int i=0; i<N; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();

        Arrays.sort(a);

        double mindist = Double.MAX_VALUE;
        int indexI = 0;
        for (int i=0; i<N-1; i++) {
            // 排序之后 a[i+1]-a[i] > 0
            if (a[i+1]-a[i] < mindist) {
                mindist = a[i+1]-a[i];
                indexI = i;
            }
        }

        StdOut.println("最近的一对是： "+a[indexI] + " " + a[indexI+1]);
    }
}
