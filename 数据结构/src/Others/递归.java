package Others;

public class 递归 {
    public static void main(String[] args) {
        int[] arr = {1, 23, 42, 5, 4, 63, 1, 4, 3242};
        System.out.println(getMax(arr));
    }

    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    public static int process(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int mid = L + ((R - L) >> 1);
        int leftMax = process(arr, L, mid);
        int rightMax = process(arr, mid + 1, R);
        return Math.max(leftMax, rightMax);
    }
}
