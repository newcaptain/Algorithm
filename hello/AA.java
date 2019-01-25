import edu.princeton.cs.algs4.StdOut;

class ab{
    int a;
    int b;

    public ab(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

public class AA<T> {

    T[] val;

    T x;

    public AA(T item) {
        this.val = (T[])new Object[1];
//        this.val[0] = item;
//        x = (T)new Object();

    }


    public T rt() {
        return val[0];
    }

    public static void main( String[] args) {
        AA<String> st = new AA<>("afsd");

//        Object[] obj = st.val;
//        int i = ((ab)obj[0]).a;
//        ab obj = (ab) st.val[0];
//        StdOut.println(((ab)((Object[])st.val)[0]).a);
//        StdOut.println(st.val.getClass());
    }
}
