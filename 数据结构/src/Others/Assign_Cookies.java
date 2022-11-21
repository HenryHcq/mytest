package Others;

import java.util.Arrays;

public class Assign_Cookies {
    public static void main(String[] args) {
        int[] children = {2, 1, 5, 2, 5, 6, 3, 8};
        int[] cookies = {2, 3, 1, 10, 4, 2, 5, 6};
        System.out.println(findContentChildren(children, cookies));
    }

    public static int findContentChildren(int[] children, int[] cookies) {
        Arrays.sort(children);
        Arrays.sort(cookies);
        int child = 0;
        int cookie = 0;
        while (child < children.length && cookie < cookies.length) {
            if (children[child] <= cookies[cookie]) {
                child++;
            }
            cookie++;
        }
        return child;
    }
}
