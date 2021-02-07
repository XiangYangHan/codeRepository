package lc.book.arrayAndString.chap06;

import java.util.Arrays;

/**
 *  题目描述：
 *      给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 *      https://leetcode-cn.com/problems/move-zeroes/
 */
public class MoveZero {

    public static void main(String[] args) {
        MoveZero instance = new MoveZero();
        int[] nums = {0, 1, 0, 3, 12};
        instance.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int f = 0, s = 0;
        while (f < nums.length) {
            if (nums[f] != 0) {
                if (f != s) {
                    nums[s] = nums[f];
                    nums[f] = 0;
                }
                s++;
            }
            f++;
        }
    }
}
