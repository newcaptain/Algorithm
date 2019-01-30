package Chapter1.Section5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 路径压缩的加权quick-union算法
 */
public class N13 {
    static int N = 10;
    static int[] a = new int[N];
    static int[] w = new int[N];

    static boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    static int find(int x) {
        if (x != a[x]) {
            a[x] = find(a[x]);
        }
        return a[x];
    }

    static void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if (w[qID] > w[pID]) {
            a[pID] = qID;
            w[qID] += w[pID];
        } else {
            a[qID] = pID;
            w[pID] += w[qID];
        }
    }

    public static void main(String[] args) {
        for (int i=0; i<N; i++) {
            w[i] = 1;
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
            StdOut.print(w[i] + " ");
        }
        StdOut.println();
        for (int i=0; i<N; i++) {
            StdOut.print(i + " ");
        }

    }
}
