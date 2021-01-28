package lc.book.arrayAndString.chap03;

import java.util.Arrays;

/**
 *  题目描述
 *      编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 *
 *      https://leetcode-cn.com/leetbook/read/array-and-string/ciekh/
 */
public class ZeroMatrix {

    public static void main(String[] args) {
        ZeroMatrix zeroMatrix = new ZeroMatrix();
        int[][] matrix = new int[][]{{1,1,1,},{1,0,1,},{1,1,1,},};
        zeroMatrix.setAndPrint(matrix);
        matrix = new int[][]{{0,1,2,0,},{3,4,5,6,},{7,8,9,0},};
        zeroMatrix.setAndPrint(matrix);
    }

    public void setAndPrint(int[][] matrix) {
        this.setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }


    public void setZeroes(int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        boolean[] zeroRow = new boolean[rowLen];
        boolean[] zeroCol = new boolean[colLen];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < colLen; col++) {
                if (matrix[row][col] == 0) {
                    if (!zeroRow[row]) { // 使用一次判断来避免重复写入
                        zeroRow[row] = true;
                    }
                    if (!zeroCol[col]) {
                        zeroCol[col] = true;
                    }
                }
            }
        }

        for (int row = 0; row < rowLen; row++) {
            if (zeroRow[row]) {
                matrix[row] = new int[colLen];
            }
        }
        for (int col = 0; col < colLen; col++) {
            if (zeroCol[col]) {
                for (int row = 0; row < rowLen; row++) {
                    if (!zeroRow[row]) {
                        matrix[row][col] = 0;
                    }
                }
            }
        }
    }
}
