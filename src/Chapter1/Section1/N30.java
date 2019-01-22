package Chapter1.Section1;

import edu.princeton.cs.algs4.StdOut;

public class N30 {
    private static int N = 5;
    public static boolean isCoprime(int a, int b) {
        if (a==1 && b==1)
            return true;
        if (a<=0 || b<=0 || a==b)
            return false;
        if (a==1 || b==1)
            return true;
        int tmp = 0;
        while (true) {
            tmp = a%b;
            if (tmp == 0) {
                break;
            } else {
                a = b;
                b =tmp;
            }
        }
        if (b == 1) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        boolean[][] a = new boolean[N][N];
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                a[i][j] = isCoprime(i, j);
            }
        }
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                StdOut.print(a[i][j] + " ");
            }
            StdOut.println();
        }

    }
}
