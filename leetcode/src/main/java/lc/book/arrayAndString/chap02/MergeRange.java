package lc.book.arrayAndString.chap02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目描述：
 *      给出一个区间的集合，请合并所有重叠的区间。
 *
 * https://leetcode-cn.com/leetbook/read/array-and-string/c5tv3/
 */

public class MergeRange {
    public static void main(String[] args) {
        int[][] test = {{1,2}};
        test = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        MergeRange mergeRange = new MergeRange();
        System.out.println(Arrays.deepToString(mergeRange.merge(test)));
    }

    public int[][] merge(int[][] intervals) {
        return mergeOrdered(sortByZeroIndex(intervals, 0, intervals.length - 1));
    }

    public int[][] sortByZeroIndex(int[][] intervals, int si, int ei) {
        if(si < ei) {
            int boundary = si; // 分界右边的都比哨兵值小
            int[] sentinel = intervals[ei]; // 最后一个最为哨兵
            for(int i = si; i < ei; i++) {
                if(intervals[i][0] < sentinel[0]) { // 比哨兵值小
                    swap(intervals, i, boundary++); // 交换至分界处
                }
            }
            swap(intervals, ei, boundary); // 交换至分界处
            sortByZeroIndex(intervals, si, boundary - 1);
            sortByZeroIndex(intervals, boundary + 1, ei);
        }
        return intervals;
    }

    public int[][] mergeOrdered(int[][] intervals) {
        List<int[]> resultList = new ArrayList<>();
        int[] t = intervals[0];
        int l = t[0];
        int h = t[1];

        for(int i = 1; i < intervals.length; i++) {
            t = intervals[i];
            if(t[0] > h) {
                int[] pair = {l,h};
                resultList.add(pair);
                l = t[0];
                h = t[1];
            }
            if(t[1] > h) {
                h = t[1];
            }
        }
        int[] pair = {l,h};
        resultList.add(pair);

        return resultList.toArray(new int[0][]);
    }

    public void swap(int[][] intervals, int from, int to) {
        int[] temp = intervals[from];
        intervals[from] = intervals[to];
        intervals[to] = temp;
    }
}