package Chapter1.Section1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 判断小数点后三位用强制类型转换把double类型->int类型
 */
public class N35 {
    private static int SIDES = 6;
    private static double[] dist = new double[2*SIDES+1];
    private static int[] times = new int[2*SIDES+1];
    private static double[] mydist = new double[2*SIDES+1];
    private static int N = 0;

    // 准确的概率
    public static void accurate() {
        for (int i=1; i<=SIDES; i++) {
            for (int j=1; j<=SIDES; j++) {
                dist[i+j] += 1.0;
            }
        }
        for (int k=2; k<=2*SIDES; k++) {
            dist[k] /= 36.0;
        }
    }

    // N次试验后的概率比较
    public static boolean isEqualAnswer() {
        // 算概率
        for (int i=2; i<=2*SIDES; i++) {
            if ((int)(times[i]*1.0/N*1000) != (int)(dist[i]*1000)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        accurate();
        while (true) {
            N++;
            int a = StdRandom.uniform(1, 7);
            int b = StdRandom.uniform(1, 7);
            times[StdRandom.uniform(1,7) + StdRandom.uniform(1,7)] ++;
            if (isEqualAnswer()) {
                break;
            }
        }
        StdOut.println(N);

    }
}
