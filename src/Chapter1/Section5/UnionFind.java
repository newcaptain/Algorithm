package Chapter1.Section5;

public class UnionFind {

    private int[] a;   // union-find的数组
    private int[] w;   // 设置权值的数组
    private int N;      // 数组长度

    public UnionFind(int n) {
        N = n;
        a = new int[N];
        w = new int[N];

        for (int i=0; i<N; i++) {
            a[i] = i;
            w[i] = 1;
        }
    }

    public int find(int x) {
        if (a[x] != x) {
            a[x] = find(a[x]);
        }
        return a[x];
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int ap = find(p);
        int aq = find(q);

        if (ap == aq) {
            return;
        }

        if (w[ap] > w[aq]) {
            a[aq] = ap;
            w[ap] += w[aq];
        } else {
            a[ap] = aq;
            w[aq] += w[ap];
        }
    }


}
