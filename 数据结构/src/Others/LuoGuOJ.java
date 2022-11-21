package Others;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class LuoGuOJ {
    public static void main(String[] args) {
        String s = "III";
        System.out.println(romanToInt(s));
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(i, nums[i]);
//        }
//        for (int i = 0; i < nums.length; i++) {
//            int other = target - nums[i];
//            for (int j = 0; j < map.size(); j++) {
//                if (map.get(j) == other)
//                    return new int[]{i, j};
//            }
//        }
//        return null;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {//是否在哈希表中，不在的话放入哈希表
                /**
                 * 如2 7 11 15 target = 9
                 *
                 */
                return new int[]{map.get(target - nums[i])};
            }
            map.put(nums[i], i);//键为值，值为下标
        }
        return new int[0];
    }

    public static boolean isPalindrome(int x) {
        String x_string = Integer.toString(x);
        char[] x_char = x_string.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : x_char
        ) {
            stack.push(c);
        }
        for (int i = 0; i < x_char.length; i++) {
            if (x_char[i] != stack.pop().charValue()) {
                return false;
            }
        }
        return true;
        /**
         * public boolean isPalindrome(int x) {
         *         String reversedStr = (new StringBuilder(x + "")).reverse().toString();
         *         return (x + "").equals(reversedStr);
         *     }
         */

        /**
         * class Solution {
         *     public boolean isPalindrome(int x) {
         *         //边界判断
         *         if (x < 0) return false; 负数不是回文数
         *         int div = 1;
         *         //
         *         while (x / div >= 10) div *= 10; 算最高可以除几次10 也就是位数
         *         while (x > 0) {
         *             int left = x / div;
         *             int right = x % 10;
         *             if (left != right) return false;
         *             x = (x % div) / 10; x % div 是去除首位 再/10是去除末尾
         *             div /= 100; 因为去掉了两位所以整体小了100
         *         }
         *         return true;
         *     }
         * }
         */
    }

    public static int romanToInt(String s) {
        /**
         * 字符          数值
         * I             1
         * V             5
         * X             10
         * L             50
         * C             100
         * D             500
         * M             1000
         */
        char[] array = s.toCharArray();
        int sum = 0;
        int preNum = getValue(array[0]);
        for (int i = 1; i < array.length; i++) {
            if (preNum >= getValue(array[i])) {
                sum += preNum;
            } else {
                sum -= preNum;
            }
            preNum = getValue(array[i]);
        }
        sum += preNum;
        return sum;
    }

    public static int getValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }

        return 0;
    }
}
