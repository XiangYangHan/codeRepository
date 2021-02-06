package lc.book.arrayAndString.chap06;

import java.util.ArrayList;
import java.util.List;

public class YangHuiTriangle_2 {

    public static void main(String[] args) {
        print(0);
        print(1);
        print(2);
        print(3);
        print(4);
        print(5);
        print(10);
        print(20);
        print(30);
        print(33);
    }

    public static void print(int rowIndex) {
        long start = System.currentTimeMillis();
        YangHuiTriangle_2 instance = new YangHuiTriangle_2();
        System.out.println(instance.getRow(rowIndex));
        System.out.println(rowIndex + " 耗时:" + (System.currentTimeMillis() - start));
    }


    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        int[] nums = new int[rowIndex+1];
        for (int i = 0; i <= rowIndex; i++) {
            int lt = 1, rt, sum;
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    nums[j] = 1;
                } else {
                    rt = nums[j];
                    sum = lt + rt;
                    nums[j] = sum;
                    lt = rt;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            result.add(nums[i]);
        }
        return result;
    }
}
