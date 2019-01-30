package Chapter1.Section5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 路径压缩的quick-union算法, 最优算法
 */
public class N12 {
    static int N = 10;
    static int[] a = new int[N];

    public static int find(int p) {
        if (p != a[p])
            a[p] = find(a[p]);
        return a[p];
    }

    public static boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public static void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if (pID == qID)
            return;

        a[pID] = a[qID];
    }


    public static void main(String[] args) {
        for (int i=0; i<N; i++) {
            a[i] = i;
        }

        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();

            if (isConnected(p, q))
                continue;

            union(p, q);
        }

        for (int i=0; i<N; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
        for (int i=0; i<N; i++) {
            StdOut.print(i + " ");
        }
    }
}
