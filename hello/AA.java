import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AA<T> {

    public void add(T s) {
        StdOut.println(s);
    }

    public static void main(String[] args) {
        AA a = new AA();
        a.add("asdf");
        a.add(123);
    }
}
