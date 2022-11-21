package Others;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Arrays;

public class SortSolutions {
    public static void main(String[] args) {
        int[] arr = {23, 4, 45, 23, 14, 5, 1};
//        SelectSort(arr);
//        BubbleSort(arr);
//        InsertSort(arr);
//        System.out.println(Dichotomous(arr, 23));
//        process(arr, 0, arr.length - 1);
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void BubbleSort(int[] arr) {
        if (arr.length < 2 || arr == null) {
            return;
        }
        for (int N = arr.length - 1; N > 0; N--) {
            for (int i = 0; i < N; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    public static void SelectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int minIndex = 0;
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            minIndex = i;
            for (int j = i + 1; j < N; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    public static void InsertSort(int[] arr) {
        if (arr == null && arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            //0-i上有序
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
//            for (int j = i; j >= 1; j--) {
//                if (arr[j] < arr[j - 1]) {
//                    swap(arr, j, j - 1);
//                }
//            }
        }
    }

    public static Boolean Dichotomous(int[] arr, int number) {
        if (arr == null || arr.length == 0) {
            return false;
        }
//        int middle = arr.length / 2;
        int head = 0;
        int end = arr.length - 1;
        while (head <= end) {
            int middle = (head + end) / 2;
            if (number > arr[middle]) {
                head = middle + 1;
            } else if (number < arr[middle]) {
                end = middle - 1;
            } else if (number == arr[middle]) {
                return true;
            }
        }
        return false;
    }

    public static void process(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;//服务于辅助数组
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }
    }

    public static int[] partition(int[] arr, int l, int r) {
        int less = l - 1;//左区域
        int more = r;//右区？
        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);//左区右扩
            } else if (arr[l] > arr[r]) {
                swap(arr, --more, l);//右区左扩
            } else {
                l++;
            }
        }
        swap(arr, more, r);
        return new int[]{less + 1, more};
    }

    public static void swap(int[] arr, int i, int j) {
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
