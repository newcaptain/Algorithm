package Chapter1.Section1;

import edu.princeton.cs.algs4.StdOut;

// DO: 将计算过的值保存在数组中并给出一个更好的实现
public class N27 {

    public static double binomial(int N, int k, double p) {
        if (N == 0 && k == 0) {
            return 1.0;
        }
        if (N < 0 || k < 0) {
            return 0.0;
        }
        return (1.0-p)*binomial(N-1,k,p)+p*binomial(N-1,k-1,p);
    }

    public static double newbinomial(int N, int k, double p) {

        double[][] arry = new double[N][k+1];

        double q = 1.0-p;

        // 构造二维数组
        arry[0][0] = 1.0;
        for (int i=1; i<N; i++) {
            arry[i][0] = q*arry[i-1][0];
        }
        for (int i=1; i<N; i++) {
            for (int j=1; j<=k; j++) {
                arry[i][j] = q*arry[i-1][j] + p*arry[i-1][j-1];
            }
        }
        return q*arry[N-1][k]+p*arry[N-1][k-1];
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        StdOut.println("基本方法输出： " + binomial(30,30,0.25));
        long endTime = System.currentTimeMillis();
        StdOut.println("基本方法运行： " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        StdOut.println("改进方法输出： " + newbinomial(30,30,0.25));
        endTime = System.currentTimeMillis();
        StdOut.println("改进方法运行： " + (endTime-startTime) + "ms");
    }
}
