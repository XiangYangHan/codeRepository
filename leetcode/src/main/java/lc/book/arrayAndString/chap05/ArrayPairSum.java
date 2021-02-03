package lc.book.arrayAndString.chap05;

import java.util.Arrays;

/**
 *  题目描述：
 *      给定长度为 2n 的整数数组 nums ，你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从 1 到 n 的 min(ai, bi) 总和最大。
 *
 *      https://leetcode-cn.com/problems/array-partition-i/
 */
public class ArrayPairSum {

    public static void main(String[] args) {
        ArrayPairSum instance = new ArrayPairSum();
        int[] nums = new int[]{1, 3, 2};
        instance.sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{-1, 3, 2, 9, -5, 6, 3, 0};
        instance.sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{6, 2, 6, 5, 1, 2};
        instance.sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        System.out.println(instance.arrayPairSum(nums));

    }

    public int arrayPairSum(int[] nums) {
        sort(nums, 0, nums.length - 1);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    public void sort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int i = l, j = l;
        while (j < r) {
            if (nums[j] < nums[r]) {
                swap(nums, i++, j++);
            } else {
                j++;
            }
        }
        swap(nums, i, r);
        sort(nums, l, i - 1);
        sort(nums, i + 1, r);
    }

    public void swap(int[] nums, int l, int r) {
        if (r == l) {
            return;
        }
        nums[l] ^= nums[r];
        nums[r] ^= nums[l];
        nums[l] ^= nums[r];
    }
}
