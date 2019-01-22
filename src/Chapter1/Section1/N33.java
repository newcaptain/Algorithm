package Chapter1.Section1;

import edu.princeton.cs.algs4.StdOut;

public class N33 {

    /**
     * 向量点乘
     * @param x
     * @param y
     * @return x0*y0 + x1*y1 + ... xn*yn
     */
    public static double dot(double[] x, double[] y) {
        double res = 0;
        for (int i=0; i<(x.length>y.length?y.length:x.length); i++) {
            res += x[i]*y[i];
        }
        return res;
    }

    /**
     * 矩阵相乘
     * @param a
     * @param b
     * @return
     */
    public static double[][] mult(double[][] a, double[][] b) {
        if (a[0].length != b.length) {
            return null;
        }

        int r = a.length;
        int c = b[0].length;

        double[][] res = new double[r][c];
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                int sum = 0;
                for (int k=0; k<b.length; k++) {
                    sum += a[i][k]*b[k][j];
                }
                res[i][j] = sum;
            }
        }
        return res;
    }

    /**
     * 转置矩阵
     * @param a
     * @return
     */
    public static double[][] transpose(double[][] a) {
        for (int i=0; i<a.length; i++) {
            for (int j=0; j<i; j++) {
                double tmp = a[j][i];
                a[j][i] = a[i][j];
                a[i][j] = tmp;
            }
        }
        return a;
    }

    /**
     * 矩阵和向量相乘  // TODO: 未验证
     * @param a
     * @param x
     * @return
     */
    public static double[] mult(double[][] a, double[] x) {
        if (a.length != x.length){
            return null;
        }
        double[] res = new double[a.length];
        for (int i=0; i<a.length; i++) {
            for (int j=0; j<x.length; j++) {
                res[j] += a[i][j]*x[j];
            }
        }
        return res;
    }

    /**
     * 向量和矩阵相乘  TODO: 未验证
     * @param y
     * @param a
     * @return
     */
    public static double[] mult(double[] y, double[][] a) {
        if (y.length != a.length) {
            return null;
        }
        double[] res = new double[y.length];
        for (int i=0; i<y.length; i++) {
            for (int j=0; j<a.length; j++) {
                res[i] += y[i]*a[j][i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        double[][] a = {{1,2,3},{4,5,6},{7,8,9}};
        for (int i=0; i<a.length; i++) {
            for (int j=0; j<a[i].length; j++) {
                StdOut.print(a[i][j] + " ");
            }
            StdOut.println();
        }
        StdOut.println();
        double[][] b = transpose(a);
        for (int i=0; i<b.length; i++) {
            for (int j=0; j<b[i].length; j++) {
                StdOut.print(b[i][j]+" ");
            }
            StdOut.println();
        }
    }
}
