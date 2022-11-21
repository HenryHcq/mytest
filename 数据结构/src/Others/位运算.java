package Others;

import java.util.Arrays;

public class 位运算 {
    public static void main(String[] args) {

        int[] arr = {1, 1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4};
//        int odd = SearchOdd(arr);
//        System.out.println(odd);
        SearchTwoOdds(arr);

    }

    /**
     * 数组中只有一个数出现了奇数次，其他所有数都出现了偶数次，使用异或运算处理
     *
     * @param arr
     */
    public static int SearchOdd(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor = eor ^ arr[i];
        }
        return eor;
    }

    /**
     * 数组中有两个数出现了奇数次，其他所有数都出现了偶数次，使用异或运算处理
     * eor先异或出来的一定是a^b 无法直接得到a还是b的值
     * 但是a^b出来的eor一定是有某位为1的（两个数是不一样的）
     * 假设这位1的位置在第8位 肯定有其他数的位置不在第8位
     * a是第8位为1的，b是第8位位0的
     * 另开辟eor' 让其与第8位是1的进行异或运算 得到的结果一定是a
     * 因为如果其他数第8位是1的话 都会在第一方阵里面 是偶数次的
     * 所以得到的一定是a
     * 反之亦然
     *
     * @param arr
     * @return
     */
    public static void SearchTwoOdds(int[] arr) {
        int eor = 0;
        for (int curNum : arr
        ) {
            eor ^= curNum;
        }//直接取出a^b
//        System.out.println(eor);
        int rightOne = eor & (~eor + 1);//提取出最右边的1 ~是取反 ~eor+1即是eor的补码
//        System.out.println(rightOne);
        int onlyOne = 0;//即eor'
        for (int curNum : arr
        ) {
            if ((curNum & rightOne) == rightOne) {//相同为1 不同为0
                onlyOne ^= curNum;
            }
        }
        System.out.println((eor ^ onlyOne) + " " + onlyOne);
    }


    public static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? 0 : 1);//1<<i的意思是左移几位
            /*
                这个函数的意思就是num本地会存在一个二进制的值，
                然后通过1左移 与 num的值进行位运算 &是1和1才是1
                不然都是0
             */
        }
        System.out.println();
    }
}
