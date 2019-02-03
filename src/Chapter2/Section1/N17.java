package Chapter2.Section1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 排序动画
 */
public class N17 extends Templ {
    public static void insertion(Comparable[] a) {
        for (int i=1; i<a.length; i++) {
            for (int j=i; j>0&&less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
            show(a);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void selection(Comparable[] a) {
        for (int i=0; i<a.length; i++) {
            int min = i;
            for (int j=i; j<a.length; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            show(a);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            exch(a, min, i);
        }
    }

    public static void show(Comparable[] a) {
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BOOK_BLUE);
        double offset = 0.02;
        double gap = 0.01;

        // 确定最高点
        Double max = (Double) a[0];
        for (int i=1; i<a.length; i++) {
            if (less(max, a[i])) {
                max = (Double) a[i];
            }
        }
        // 把最高的半高作为标准
        double maxHalfHeight = (1-offset*2)/2;

        // 确定宽度
        double halfwidth = (1-offset*2-(a.length-1)*gap)/a.length/2;

        for (int i=0; i<a.length; i++) {
            double halfheight = ((Double)a[i]).doubleValue()/max*maxHalfHeight;

            StdDraw.filledRectangle(offset+(2*i+1)*halfwidth+i*gap, offset+halfheight, halfwidth, halfheight);
        }

    }

    public static void main(String[] args) {
        // 生成随机数据
        int N = StdRandom.uniform(12, 60);
        Double[] a = new Double[N];
        for (int i=0; i<N; i++) {
            a[i] = StdRandom.uniform(1.0, 100.0);
        }
        selection(a);
    }
}
