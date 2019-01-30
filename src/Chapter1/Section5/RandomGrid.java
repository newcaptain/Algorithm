package Chapter1.Section5;

import Chapter1.Section3.RandomBag;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

/**
 * 随机网络生成器
 */
public class RandomGrid {
    // 嵌套类
    public static class Connection {
        int p;
        int q;

        public Connection(int p, int q) {
            this.p = p;
            this.q = q;
        }
    }

    public static RandomBag<Connection> generate(int N) {
        RandomBag<Connection> res = new RandomBag<>();

        // i行和i-1行连接
        for (int i=1; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (StdRandom.bernoulli(0.5)) {
                    res.add(new Connection(N*i+j, N*(i-1)+j));
                }
            }
        }

        // j列和j-1列连接
        for (int i=0; i<N; i++) {
            for (int j=1; j<N; j++) {
                if (StdRandom.bernoulli(0.5)) {
                    res.add(new Connection(N*i+j, N*i+j-1));
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        RandomBag<Connection> x = generate(10);
        Iterator it = x.iterator();
        while (it.hasNext()) {
            Connection t = (Connection) it.next();
            StdOut.println(t.p + " " + t.q);
        }
    }
}
