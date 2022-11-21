package Others;

import java.util.Arrays;
import java.util.Comparator;

public class pp1 {
    public static void main(String[] args) {
        int[][] arrays = {{1, 2}, {3, 4}, {4, 5}, {5, 6}};
        Arrays.sort(arrays, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
//                return Integer.compare(o1[1], o2[1]);
                return o1[1] < o2[1] ? -1 : 1;
            }
        });
        for (int[] i : arrays
        ) {
            System.out.println(Arrays.toString(i));
        }
    }
}
