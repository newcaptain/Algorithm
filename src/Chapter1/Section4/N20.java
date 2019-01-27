package Chapter1.Section4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 双调查找
 * 题目是先单增然后单减。
 * 对于任意分，必定有一边是单调的。或者两边都是单调的。
 * 对于单调的采用二分查找
 */
public class N20 {

    public static int binarySearch(int[] a, int lo, int hi, int key, boolean isIncrease) {
        int l = lo;
        int r = hi;
        while (l <= r) {
            int mid = (l+r)/2;

            if (a[mid] == key) {
                return mid;
            } else if (a[mid] < key) {
                if (isIncrease) {
                    l = mid+1;
                } else {
                    r = mid-1;
                }
            } else {
                if (isIncrease) {
                    r = mid-1;
                } else {
                    l = mid+1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int N = 10;
        int[] a = new int[N];
        a[0] = 10;
        a[1] = 20;
        a[2] = 30;
        a[3] = 35;
        a[4] = 50;
        a[5] = 46;
        a[6] = 40;
        a[7] = 36;
        a[8] = 28;
        a[9] = 12;

        for (int i=0; i<N; i++) {
            StdOut.printf("%5d", a[i]);
        }
        StdOut.printf("\n");

        int key = a[StdRandom.uniform(0, N)];
        StdOut.println("key: " + key);
        int rs = -1;

        int lo = 0;
        int hi = N-1;

        while (lo <= hi) {
            int mid = (lo+hi)/2;
            if (a[mid] == key) {
                rs = mid;
                break;
            }
            if (a[mid] < a[mid-1]) {
                // 递减了， 说明右边是单减的
                if (key < a[mid]) {
                    rs = binarySearch(a, mid+1, hi, key, false);
                    if (rs != -1) {
                        break;
                    }
                }
                hi = mid-1;
            } else {
                // 左边单增
                if (key < a[mid]) {
                    rs = binarySearch(a, lo, mid-1, key, true);
                    if (rs != -1) {
                        break;
                    }
                }
                lo = mid+1;
            }
        }
        StdOut.println(rs + "   " + a[rs]);
    }
}
