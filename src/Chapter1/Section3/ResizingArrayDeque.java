package Chapter1.Section3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

// DO: 使用简单的方法重构代码

public class ResizingArrayDeque<T> implements Iterable<T> {
    private T[] array;
    int tail;

    public ResizingArrayDeque() {
        array = (T[]) new Object[1];
        tail = 0;
    }

    public boolean isEmpty() {
        return tail==0;
    }

    public int size() {
        return tail;
    }

    /**
     * 调整数组大小,
     * @param length
     */
    public void resize(int length) {
        T[] tmp = (T[]) new Object[length];
        for (int i=0; i<tail; i++) {
            tmp[i] = array[i];
        }
        array = tmp;
    }

    /**
     * 在数组左边插入元素，left为0时所有元素向右移动一格插入
     * @param item
     */
    public void pushLeft(T item) {
        if (size() == array.length) {
            resize(2*array.length);
        }

        for (int tmp=tail-1; tmp>=0; tmp--) {
            array[tmp+1] = array[tmp];
        }
        array[0] = item;
        tail++;
    }

    /**
     * 右插: 直接在右边插入
     * @param item
     */
    public void pushRight(T item) {
        if (size() == array.length) {
            resize(2*array.length);
        }
        array[tail++] = item;
    }

    public T popLeft() {
        T rs = array[0];
        for (int i=1; i<tail; i++) {
            array[i-1] = array[i];
        }
        if (size() > 0 && size() == array.length/4) {
            resize(array.length/2);
        }
        return rs;
    }

    public T popRight() {
        T rs = array[--tail];
        if (size() > 0 && size() == array.length/4) {
            resize(array.length/2);
        }
        return rs;
    }

    public static void main(String[] args) {
        ResizingArrayDeque<String> tst = new ResizingArrayDeque<>();
        tst.pushLeft("a");
        tst.pushLeft("b");
        tst.pushLeft("c");
        tst.pushLeft("d");
        tst.pushLeft("e");

        StdOut.println(tst.array[0]);


        for (Object x : tst) {
//         边遍历边右弹出会出错，同时-tail和遍历
            tst.popLeft();
//            StdOut.println(tst.popLeft());
        }

        tst.pushLeft("a");
        tst.pushLeft("b");
        tst.pushLeft("c");
        tst.pushLeft("d");
        tst.pushLeft("e");


        tst.pushRight("my");
        tst.pushRight("name");
        tst.pushRight("is");
        tst.pushRight("china");
        tst.pushRight("uuu");
        tst.pushRight("bb");
        tst.pushRight("a");
        tst.pushRight("123");
        tst.pushRight("456");

        for (String x : tst) {
            StdOut.print(x + " ");
        }
        StdOut.println();
        for (String x : tst) {
            StdOut.print(x + " ");
        }

    }

    @Override
    public Iterator iterator() {
        return new myIterator();
    }

    class myIterator implements Iterator<T> {

        int idx = 0;

        @Override
        public boolean hasNext() {
            return idx!=tail;
        }

        @Override
        public T next() {
            T rs = array[idx];
            idx++;
            return rs;
        }
    }
}
