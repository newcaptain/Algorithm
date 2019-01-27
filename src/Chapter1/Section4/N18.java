package Chapter1.Section4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 数组中的局部最小值
 */
public class N18 {
    public static void main(String[] args) {
        int N = 10;
        double a[] = new double[N];
        for (int i=0; i<N; i++) {
            a[i] = StdRandom.uniform(-10.0, 10.0);
        }

        for (int i=0; i<N; i++) {
            StdOut.printf("%.6f  ",a[i]);
        }
        StdOut.println();

        int l = 0;
        int r = N-1;
        while(l <= r) {
            int mid = (l+r)/2;
            double x = a[mid];
            if (mid == l || mid == r) {
                // 在最边缘就是局部最小
                break;
            } else {
                if (x < a[mid-1] && x < a[mid+1]) {
                    break;
                } else {
                    // 二分，
                    if (a[mid-1] > a[mid+1]) {
                        l = mid+1;
                    } else {
                        r = mid-1;
                    }
                }
            }
        }
        StdOut.println(a[(l+r)/2]);
    }
}
