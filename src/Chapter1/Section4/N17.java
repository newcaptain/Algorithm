package Chapter1.Section4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * 最遥远的一对
 * 题目要求线性级别，好像不能用排序取开头和结尾
 * 应该是找最小和最大两个数
 */
public class N17 {
    public static void main(String[] args) {
        int N = 10;
        double[] a = new double[N];
        for (int i=0; i<N; i++) {
            a[i] = StdRandom.uniform(-10.0, 10.0);
        }

        for (int i=0; i<N; i++) {
            StdOut.printf("%.4f ", a[i]);
        }
        StdOut.println();
        Arrays.sort(a);

        double minval = Double.MAX_VALUE;
        double maxval = -Double.MAX_VALUE;

        for (int i=0; i<N; i++) {
            if (a[i] < minval) {
                minval = a[i];
            }
            if (a[i] > maxval) {
                maxval = a[i];
            }
        }

        StdOut.println("差距最大的两个数是: " + maxval + " " + minval);
    }
}
