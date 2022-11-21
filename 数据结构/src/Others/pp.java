package Others;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class pp {
    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 6, 2, 3, 7, 9, 8};
//        SelectSort(arr);
//        BubbleSort(arr);
//        InsertSort(arr);
//        HeapSort(arr);
//        MergeSort(arr);
//        QuickSort2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void SelectSort(int[] arr) {
        int min_index = 0;
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            min_index = i;
            for (int j = i + 1; j < N; j++) {
                min_index = arr[min_index] > arr[j] ? j : min_index;
            }
            Swap(arr, min_index, i);
        }
    }

    public static void BubbleSort(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    Swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void InsertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                Swap(arr, j, j + 1);
            }
        }
    }


    public static void HeapSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            HeapInsert(arr, i);
        }

        int size = arr.length;
        Swap(arr, 0, --size);
        while (size > 0) {
            Heapify(arr, 0, size);
            Swap(arr, 0, --size);
        }
    }

    public static void HeapInsert(int[] arr, int index) {
        while (arr[(index - 1) / 2] < arr[index]) {
            Swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void Heapify(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {//左子树越界
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;

            if (largest == index) {
                break;
            }
            Swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void MergeSort(int[] arr) {
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int M = L + ((R - L) >> 1);
        process(arr, L, M);
        process(arr, M + 1, R);
        merge(arr, L, M, R);
    }

    public static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] >= arr[p2] ? arr[p2++] : arr[p1++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }

        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }
    }


    public static void QuickSort(int[] arr, int start, int end) {

//        int base = arr[L];
        int low = start;
        int high = end;
        if (start < end) {
            int guard = arr[start];
            while (low != high) {
                while (low < high && arr[high] >= guard) {
                    high--;
                }
                while (low < high && arr[low] <= guard) {
                    low++;
                }
                if (low < high) {
                    int temp = arr[low];
                    arr[low] = arr[high];
                    arr[high] = temp;
                }
            }
            arr[start] = arr[low];
            arr[low] = guard;
            QuickSort(arr, start, low - 1);
            QuickSort(arr, low + 1, end);
        }
    }

    public static void QuickSort2(int[] arr, int start, int end) {
        int low = start, high = end;
        if (start < end) {
            int guard = arr[start];//哨兵元素
            while (low != high) {
                while (high > low && arr[high] >= guard) high--;
                arr[low] = arr[high];
                while (low < high && arr[low] <= guard) low++;
                arr[high] = arr[low];
            }
            arr[low] = guard;
            QuickSort2(arr, start, low - 1);
            QuickSort2(arr, low + 1, end);
        }
    }


    public static void Swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
