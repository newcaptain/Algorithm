package Chapter1.Section3;

import edu.princeton.cs.algs4.StdOut;

// DO: 增加测试用例进行测试
public class RingBuffer<T> {
    T[] array;
    int head;
    int tail;

    int arrayLength = 5;

    public RingBuffer() {
        this.array = (T[]) new Object[arrayLength];
        this.head = 0;
        this.tail = 0;
    }

    public void add(T item) {
        if (tail >= arrayLength) {
            tail = 0;
        }
        if (tail == head-1 || (tail == arrayLength-1 && head == 0)) {
            StdOut.println("缓冲区满了，不能添加元素了");
            return;
        }
        array[tail++] = item;
    }

    public T delete() {
        if (head >= arrayLength) {
            head = 0;
        }
        if (head == tail) {
            // 缓冲区为空
            StdOut.println("缓冲区为空。");
            return null;
        }
        T rs = array[head];
        array[head++] = null;
        return rs;
    }

    public static void main(String[] args) {
        RingBuffer<String> test = new RingBuffer<>();
        test.add("a");
        test.add("b");
        test.add("c");
        test.add("d");
        test.add("e");
        test.add("f");

        StdOut.println("tail: " +  test.tail);
        for (int i=test.head; i!=test.tail; i++) {
            Object[] tmp = test.array;
            StdOut.println(i + ": " + tmp[i]);
        }

        test.delete();
        test.delete();
        test.delete();
        test.delete();
        test.delete();
        test.delete();
    }
}
