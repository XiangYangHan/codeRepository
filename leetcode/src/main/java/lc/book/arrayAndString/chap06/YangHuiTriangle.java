package lc.book.arrayAndString.chap06;

import java.util.ArrayList;
import java.util.List;

/**
 *  题目描述：
 *      给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *      https://leetcode-cn.com/problems/pascals-triangle/
 */
public class YangHuiTriangle {

    public static void main(String[] args) {

        YangHuiTriangle instance = new YangHuiTriangle();
        System.out.println(instance.generate(0));
        System.out.println(instance.generate(1));
        System.out.println(instance.generate(2));
        System.out.println(instance.generate(5));
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> rowNumbers = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    rowNumbers.add(1);
                } else {
                    List<Integer> prevRowNums = result.get(i - 1);
                    rowNumbers.add(prevRowNums.get(j - 1) + prevRowNums.get(j));
                }
            }
            result.add(rowNumbers);
        }
        return result;
    }
}
