package lc.book.arrayAndString.chap05;

/**
 *  题目描述
 *      给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 *
 *      https://leetcode-cn.com/leetbook/read/array-and-string/c0w4r/
 */
public class MinSubArrayLen {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        MinSubArrayLen instance = new MinSubArrayLen();
        System.out.println(instance.minSubArrayLen(7, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length + 1;
        int high = 0, low = 0;
        int sum = 0;

        while (true) {
            if (sum < target) {
                if (high == nums.length) {
                    break;
                }
                sum += nums[high++];
            } else {
                sum -= nums[low++];
            }
            if (sum >= target) {
                if (high - low < len) {
                    len = high - low;
                }
            }
        }
        if (len > nums.length) {
            len = 0;
        }
        return len;
    }
}
