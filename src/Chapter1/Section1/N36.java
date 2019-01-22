package Chapter1.Section1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class N36 {
    private static int M;
    private static int N;

    public static void initArray(int[] arry) {
        for (int i=0; i<arry.length; i++) {
            arry[i] = i;
        }
    }
    public static void main(String[] args) {
        M = Integer.parseInt(args[0]);
        N = Integer.parseInt(args[1]);

        int[][] react = new int[M][M];
        int[] arry = new int[M];

        initArray(arry);
        StdRandom.shuffle(arry);
        for (int i=1; i<=N; i++) {
            initArray(arry);
            StdRandom.shuffle(arry);

            for (int j=0; j<arry.length; j++) {
                react[arry[j]][j] ++;
            }
        }

        for (int i=0; i<M; i++) {
            for (int j=0; j<M; j++) {
                StdOut.print(react[i][j] + " ");
            }
            StdOut.println();
        }
    }
}
