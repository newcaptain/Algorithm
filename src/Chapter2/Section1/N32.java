package Chapter2.Section1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.sql.Time;

/**
 * 生成不同算法运行时间曲线图
 */
public class N32 {

    public static double sortTime(Double[] a) {
        Stopwatch timer = new Stopwatch();
        Insertion.sort(a);
        return timer.elapsedTime();
    }

    public static void show(double[] dt) {
        // 偏移量
        double offset = 0.05;

        int N = dt.length;

        // 设定标准宽度
        double cellwidth = (1-offset*2)/(N);

        // 设定标准高
        double mas = dt[N-1];

        StdDraw.line(offset, offset, 1-offset, offset);
        StdDraw.line(offset, offset, offset, 1-offset);

        for (int i=0; i<dt.length; i++) {
            StdDraw.circle(offset+cellwidth*(i+1), offset+(dt[i]/mas), 0.005);
        }
    }

    public static void main(String[] args) {
        // 执行次数
        int Times = StdRandom.uniform(10, 30);
        int inc = 3000;

        int alength = 1000;
        double[] data = new double[Times];
        for (int i=0; i<Times; i++) {
            Double[] a = new Double[alength];
            for (int j=0; j<alength; j++) {
                a[j] = StdRandom.uniform(0, 100.0);
            }
            double exctime = sortTime(a);
            data[i] = exctime;
            alength += inc;
        }
        show(data);
    }
}
