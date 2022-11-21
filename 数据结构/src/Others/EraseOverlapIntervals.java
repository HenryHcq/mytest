package Others;

import java.util.Arrays;
import java.util.Comparator;

public class EraseOverlapIntervals {

    public static void main(String[] args) {
        int[][] array = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(eraseOverlapIntervals(array));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {

        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];//按照右边界升序
            }
        });
        int n = intervals.length;
        int right = intervals[0][1];
        int res = 1;//第一个右边界肯定存在
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= right) {
                res++;
                right = intervals[i][1];
            }
        }

        return n - res;
    }
}
