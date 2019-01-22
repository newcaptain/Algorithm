package Chapter1.Section1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class N38 {

    public static void binarySearch(int[] arry, int[] keys) {
        Arrays.sort(arry);
        for (int i=0; i<keys.length; i++) {
            int key = keys[i];
            int lo = 0;
            int hi = keys.length-1;
            while (lo <= hi) {
                int mid = (lo+hi)/2;
                if (keys[mid] > key) {
                    hi = mid-1;
                } else if (keys[mid] < key){
                    lo = mid+1;
                } else {
                    break;
                }
            }
        }
    }

    public static void bruteForceSearch(int[] arry, int[] keys) {
        for (int i=0; i<keys.length; i++) {
            int key = keys[i];
            for (int j=0; j<arry.length; j++) {
                if (arry[j] == key) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        StdOut.println("开始执行");
        In in = new In(args[0]);
        int[] arry = in.readAllInts();
        int[] keys = StdIn.readAllInts();
        long startTime = System.currentTimeMillis();
        binarySearch(arry, keys);
        long endTime = System.currentTimeMillis();
        StdOut.println("二分查找用时: " + (endTime-startTime)+" ms");
        startTime = System.currentTimeMillis();
        bruteForceSearch(arry, keys);
        endTime = System.currentTimeMillis();
        StdOut.println("暴力查找用时: " + (endTime-startTime)+" ms");
    }
}
