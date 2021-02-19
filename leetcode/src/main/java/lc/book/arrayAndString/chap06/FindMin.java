package lc.book.arrayAndString.chap06;

/**
 *  题目描述：
 *      假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组[0,1,2,4,5,6,7] 可能变为[4,5,6,7,0,1,2] 。
 *
 *      https://leetcode-cn.com/leetbook/read/array-and-string/c3ki5/
 */
public class FindMin {

    public static void main(String[] args) {
        FindMin instance = new FindMin();
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(instance.findMin(nums));
        nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(instance.findMin(nums));
        nums = new int[]{0};
        System.out.println(instance.findMin(nums));
        nums = new int[]{1,2};
        System.out.println(instance.findMin(nums));
        nums = new int[]{1,2,3};
        System.out.println(instance.findMin(nums));
        nums = new int[]{2,1};
        System.out.println(instance.findMin(nums));
    }

    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] >= nums[0]) {
                l = mid + 1;
            } else if (nums[mid] > nums[mid - 1]) {
                r = mid - 1;
            } else {
                return nums[mid];
            }
        }
        return nums[0];
    }

}
