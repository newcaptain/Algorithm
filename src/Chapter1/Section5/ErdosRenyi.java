package Chapter1.Section5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class ErdosRenyi {
    static int[] a;
    static int[] w;
    static int N;

    public static int count(int argN) {
        N = argN;
        a = new int[N];
        w = new int[N];

        // 初始化
        for (int i=0; i<N; i++) {
            a[i] = i;
            w[i] = 1;
        }

        int cnt = 0;

        while (!allConnected()) {
            int a = StdRandom.uniform(N);
            int b = StdRandom.uniform(N);

            if (isConnected(a, b)) {
                continue;
            }
            union(a, b);
            StdOut.println(a + " 连接了 " + b);
            cnt++;
        }
        StdOut.println("总连接数是　" + cnt);
        return cnt;
    }

    private static boolean allConnected() {
        for (int i=1; i<N; i++) {
            if (!isConnected(0, i)) {
                return false;
            }
        }
        return true;
    }

    private static void union(int p, int q) {
        int pp = find(p);
        int pq = find(q);

        if (pp == pq) {
            return;
        }

        if (w[pp] > w[pq]) {
            a[pq] = pp;
            w[pp] += w[pq];
        } else {
            a[pp] = pq;
            w[pq] += w[pp];
        }
    }

    private static boolean isConnected(int a, int b) {
        return find(a) == find(b);
    }

    private static int find(int x) {
        if (x != a[x]) {
            a[x] = find(a[x]);
        }
        return a[x];
    }

    public static void main(String[] args) {
        while (!StdIn.isEmpty()) {
            int n = StdIn.readInt();
            count(n);
        }
    }
}
