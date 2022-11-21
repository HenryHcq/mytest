package Others;

import java.util.Arrays;
import java.util.Comparator;

public class FindMinArrowShots {
    public static void main(String[] args) {
        int[][] points = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        System.out.println(findMinArrowShots(points));
    }

    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];//按照右边界排序
            }
        });
        int right = points[0][1];
        int ans = 1;
        for (int[] balloon : points
        ) {
            if (balloon[0] > right) {
                ans++;
                right = balloon[1];
            }
        }
        return ans;
    }
}
