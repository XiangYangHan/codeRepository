package lc.book.arrayAndString.chap05;

import java.util.Arrays;

/**
 *  题目描述：
 *      给定一个已按照 升序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
 *
 *      https://leetcode-cn.com/leetbook/read/array-and-string/cnkjg/
 */
public class TwoSum {

    public static void main(String[] args) {
        TwoSum instance = new TwoSum();
        int[] numbers = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(instance.twoSum(numbers, 9)));
        numbers = new int[]{2, 3, 4};
        System.out.println(Arrays.toString(instance.twoSum(numbers, 6)));
        numbers = new int[]{1, 2};
        System.out.println(Arrays.toString(instance.twoSum(numbers, 3)));
        numbers = new int[]{1, 2};
        System.out.println(Arrays.toString(instance.twoSum(numbers, 3)));
        numbers = new int[]{0,0,3};
        System.out.println(Arrays.toString(instance.twoSum(numbers, 0)));
        numbers = new int[]{-1000,-1,0,1};
        System.out.println(Arrays.toString(instance.twoSum(numbers, 1)));
    }

//    public int[] twoSum(int[] numbers, int target) {
//        int[] arr = new int[2001]; // -1000 ... 0 ... 1000
//        for (int i = 0; i < numbers.length; i++) {
//            arr[numbers[i] + 1000] = i + 1;
//        }
//        int[] result = null;
//        for (int i = 0; i < arr.length; i++) {
//
//        }
//        return result;
//    }

    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        int sum;
        int[] result =  new int[2];

        while (l < r) {
            sum = numbers[l] + numbers[r];
            if (sum == target) {
                result[0] = l + 1;
                result[1] = r + 1;
                return result;
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
        return null;
    }
}
