package Chapter1.Section1;
// TODO: 将计算过的值保存在数组中并给出一个更好的实现
public class N27 {

    public static double binomial(int N, int k, double p) {
        if (N == 0 && k == 0) {
            return 1.0;
        }
        if (N < 0 || k <0) {
            return 0.0;
        }
        return (1.0 - p)*binomial(N-1, k, p)+p*binomial(N-1, k-1, p);
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        binomial(30, 50, 0.25);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
