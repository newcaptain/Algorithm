package Chapter2.Section1;

/**
 * 动画
 */
public class N17 extends Templ {
    public static void insertion(Comparable[] a) {
        for (int i=0; i<a.length; i++) {
            int min = i;
            for (int j=i; j<a.length; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, min, i);
        }
    }

    public static void selection(Comparable[] a) {

    }

    public static void Show(Comparable[] a) {
        Comparable max = a[0];
        for (int i=1; i<a.length; i++) {
            if (less(a[i], max)) {
                max = a[i];
            }
        }
        ;

    }

    public static void main(String[] args) {

    }
}
