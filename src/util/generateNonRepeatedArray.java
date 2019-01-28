package util;

import edu.princeton.cs.algs4.StdRandom;

/**
 * 生成无重复的INT类型的数组
 */
public class generateNonRepeatedArray {

    /**
     * @param args 需要的无重复int数据的个数
     */
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);

        int lo = 0;
        int hi = 10;

        int[] array = new int[N];
        for (int i=0; i<N; i++) {
//            int tmp = StdRando
            while (true) {
                int tmp = StdRandom.uniform(lo, hi);

            }
        }
    }
}
