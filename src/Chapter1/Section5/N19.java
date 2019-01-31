package Chapter1.Section5;


import Chapter1.Section3.RandomBag;
import edu.princeton.cs.algs4.StdDraw;

import java.util.Iterator;

/**
 * 生成表格动画
 */
public class N19 {

    public static void main(String[] args) {
        int N = 10;
        UnionFind uf = new UnionFind(N*N);      // 处理N×N的连接情况
        RandomBag<RandomGrid.Connection> test =RandomGrid.generate(N);  // 生成N×N的随机网格

        double offset = 1.0/N/2;   // x轴y轴偏移量
        // 画出 N×N 的表格
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                StdDraw.setPenColor(StdDraw.RED);
                StdDraw.filledEllipse(i*1.0/N+offset, j*1.0/N+offset, 0.01, 0.01);
            }
        }

        Iterator it = test.iterator();
        while (it.hasNext()) {
            RandomGrid.Connection tmp = (RandomGrid.Connection) it.next();

            if (uf.isConnected(tmp.p, tmp.q)) {
                continue;
            }
            uf.union(tmp.p, tmp.q);

            // 连线
            int pr = tmp.p/N;
            int pc = tmp.p%N;

            int qr = tmp.q/N;
            int qc = tmp.q%N;
            StdDraw.line(pc*(1.0/N)+offset, 1.0-(pr*(1.0/N)+offset), qc*(1.0/N)+offset, 1.0-(qr*(1.0/N)+offset));
        }
    }
}
