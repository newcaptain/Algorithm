package Chapter1.Section3;

import edu.princeton.cs.algs4.StdOut;

public class GeneralizedQueue<Item> {

    Item[] array;
    int N;

    public GeneralizedQueue() {
        this.array = (Item[])new Object[1];
        N = 0;
    }

    boolean isEmpty() {
        return N==0;
    }

    void resize(int l) {
        Item[] newArray = (Item[]) new Object[l];
        for (int i=0; i<N; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    void insert(Item x) {
        if (N == array.length) {
            resize(2*array.length);
        }
        array[N++] = x;
    }

    Item delete(int k) {
        Item rs = array[k];
        for (int i=k+1; i<N; i++) {
            array[i-1] = array[i];
        }
        array[--N] = null;
        if (N > 0 && N==array.length/4) {
            resize(array.length/2);
        }
        return rs;
    }

    public static void main(String[] args) {
        GeneralizedQueue<String> ay = new GeneralizedQueue<>();
        ay.insert("my");
        ay.insert("name");
        ay.insert("is");
        ay.insert("Jafas");
        ay.insert("zqq");
        ay.insert("jsadn");
        while (ay.N != 0) {
            StdOut.println(ay.delete(ay.N-1));
        }

    }

}
