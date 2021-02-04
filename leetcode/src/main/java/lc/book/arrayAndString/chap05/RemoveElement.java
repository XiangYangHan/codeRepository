package lc.book.arrayAndString.chap05;

import java.util.Arrays;

/**
 *  题目描述：
 *      给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 *      https://leetcode-cn.com/leetbook/read/array-and-string/cwuyj/
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        RemoveElement instance = new RemoveElement();
        System.out.println(instance.removeElement(nums, 2));
        System.out.println(Arrays.toString(nums));
    }

    public int removeElement(int[] nums, int val) {
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                if (fast != slow) {
                    nums[fast] ^= nums[slow];
                    nums[slow] ^= nums[fast];
                    nums[fast] ^= nums[slow];
                }
                fast++;
                slow++;
            } else {
                fast++;
            }
        }
        return slow;
    }
}
