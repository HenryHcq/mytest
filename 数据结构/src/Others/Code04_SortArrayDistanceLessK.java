package Others;

import javax.sound.sampled.Port;
import java.util.PriorityQueue;

public class Code04_SortArrayDistanceLessK {

    public static void sortedArrDistanceLessK(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();//默认小根堆
        int index = 0;
        for (; index < Math.min(arr.length, k); index++) {
            heap.add(arr[index]);
        }
        int i = 0;
        for (; index < arr.length; i++, index++) {
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }
        while (!heap.isEmpty()) {
            arr[i++] = heap.poll();
        }
    }

    public static void main(String[] args) {
        int[] arr = {123, 5, 2, 36, 23, 2, 36, 2, 7, 4, 4, 2, 424};
        sortedArrDistanceLessK(arr, 5);
    }
}
