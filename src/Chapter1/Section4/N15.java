package Chapter1.Section4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class N15 {

    public static int TwoSumFaster(int[] array) {
        int head = 0;
        int tail = array.length-1;

        int count = 0;

        while(head < tail) {
            if (array[head] + array[tail] == 0) {
                StdOut.println(array[head] + " + " + array[tail] + " = 0");
                count++;
                head++;
                tail--;
            } else if (array[head] + array[tail] < 0) {
                head++;
            } else {
                tail--;
            }
        }
        return count;
    }

    public static int ThreeSumFaster(int[] array) {
        int head;
        int tail;
        int count = 0;

        for (int i=0; i<array.length-2; i++) {
            head = i+1;
            tail = array.length-1;
            while (head < tail) {
                if (array[head] + array[tail] + array[i] == 0) {
                    StdOut.println(array[head] + " + " + array[tail] + " + " + array[i] + " = 0");
                    count++;
                    head++;
                    tail--;
                } else if (array[head] + array[tail] + array[i] < 0) {
                    head++;
                } else {
                    tail--;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int[] array = new int[10];
        for (int i=0; i<10; i++) {
            array[i] = StdRandom.uniform(-9,10);
        }
        for (int i=0; i<10; i++) {
            StdOut.print(array[i] + " ");
        }
        StdOut.println();

        // 排序
        Arrays.sort(array);

        TwoSumFaster(array);
        ThreeSumFaster(array);
    }
}
