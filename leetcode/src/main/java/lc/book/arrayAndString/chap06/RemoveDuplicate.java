package lc.book.arrayAndString.chap06;

/**
 *  题目描述：
 *      给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *      不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 *      https://leetcode-cn.com/leetbook/read/array-and-string/cq376/
 */
public class RemoveDuplicate {

    public static void main(String[] args) {

        RemoveDuplicate instance = new RemoveDuplicate();
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(instance.removeDuplicates(nums));
        nums = new int[]{1, 1, 2};
        System.out.println(instance.removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int f = 1, s = 0;
        while (f < nums.length) {
            if (nums[f] != nums[s]) {
                nums[++s] = nums[f];
            }
            f++;
        }
        return s + 1;
    }
}
