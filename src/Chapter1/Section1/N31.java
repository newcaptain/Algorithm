package Chapter1.Section1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 基本思路是把一个圆平均分成N分，这样N个点的间距就是相等的。横着排概率连线不明显
 * 然后对N个点进行概率连线
 */
public class N31 {

    private static int N = 8;
    private static double p = 0.2;

    private static final double pointRadius = 0.008;
    private static final double circleRadius = 0.3;
    private static final double x = 0.5;
    private static final double y = 0.5;

    public static void drawPoint() {
        StdDraw.setPenRadius(pointRadius);
        StdDraw.setPenColor(StdDraw.ORANGE);
        for (int i=0; i<N; i++) {
            StdDraw.point(x+circleRadius*Math.cos(2*Math.PI*i/N), y+circleRadius*Math.sin(2*Math.PI*i/N));
        }
    }

    public static void drawLine() {
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (i == j) {
                    continue;
                }
                boolean isDrawLine = StdRandom.bernoulli(p);
                if (isDrawLine) {
                    double ax = x+circleRadius*Math.cos(2*Math.PI*i/N);
                    double ay = y+circleRadius*Math.sin(2*Math.PI*i/N);

                    double bx = x+circleRadius*Math.cos(2*Math.PI*j/N);
                    double by = y+circleRadius*Math.sin(2*Math.PI*j/N);
                    StdDraw.setPenRadius(0.005);
                    StdDraw.setPenColor(StdDraw.GRAY);
                    StdDraw.line(ax, ay, bx, by);
                }
            }
        }
    }

    public static void main(String[] args) {
        drawPoint();
        drawLine();
    }

}
