package Chapter1.Section1;


import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class N39 {

    // 初始化数组， 生成随机6位数填进数组里
    public static void initArray(int[] arry) {
        for (int i=0; i<arry.length; i++) {
            arry[i] = StdRandom.uniform(100000,1000000);
        }
    }

    // 二分查找
    public static boolean binarySearch(int key, int[] arry, int lo, int hi) {
        if (lo > hi) {
            return false;
        } else {
            if (arry[(lo+hi)/2] == key) {
                return true;
            } else {
                if (arry[(lo+hi)/2] > key) {
                    return binarySearch(key, arry, lo, (lo+hi)/2-1);
                } else {
                    return binarySearch(key, arry, (lo+hi)/2+1, hi);
                }
            }
        }
    }

    // 找出数组a和b中同时存在的元素
    public static int searchCounter(int[] a, int[] b) {
        int count = 0;
        for (int i=0; i<a.length; i++) {
            if (binarySearch(a[i], b,0, b.length-1)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int T = Integer.parseInt(args[0]);  // DO: 从命令行读取T的值

        // 对每个N，执行T次
        for (int N=1000; N<=100000; N*=10) {
            int counts = 0;
            for (int i=0; i<T; i++) {
                int[] arryA = new int[N];
                int[] arryB = new int[N];
                initArray(arryA);
                initArray(arryB);
                counts += searchCounter(arryA, arryB);
            }
            StdOut.println("N: " + N + " avg: " + counts*1.0/T);
        }

    }
}
