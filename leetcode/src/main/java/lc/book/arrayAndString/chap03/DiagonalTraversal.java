package lc.book.arrayAndString.chap03;

import java.util.Arrays;

/**
 *  题目描述：
 *      给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 *
 *      https://leetcode-cn.com/leetbook/read/array-and-string/cuxq3/
 */
public class DiagonalTraversal {

    public static void main(String[] args) {
        DiagonalTraversal diagonalTraversal = new DiagonalTraversal();
        int[][] matrix = new int[][]{{1, 2, }, {4, 5, }, {7, 8, },};
        System.out.println(Arrays.toString(diagonalTraversal.findDiagonalOrder(matrix)));
        matrix = new int[][]{};
        System.out.println(Arrays.toString(diagonalTraversal.findDiagonalOrder(matrix)));
        matrix = new int[][]{{}};
        System.out.println(Arrays.toString(diagonalTraversal.findDiagonalOrder(matrix)));
    }

    public int[] findDiagonalOrder(int[][] matrix) {
        int[] result = {};
        int row = matrix.length;
        if (row == 0) {
            return result;
        }
        int col = matrix[0].length;
        if (col == 0) {
            return result;
        }
        result = new int[row * col];

        int i = 0, j = 0;
        Direction direction = Direction.RT;
        int cnt = 0;
        while (true) {
            result[cnt++] = matrix[i][j];

            switch (direction) {
                case RT:
                    if (j == col - 1) {
                        direction = Direction.LB;
                        i += 1;
                    } else if (i == 0) {
                        direction = Direction.LB;
                        j += 1;
                    } else {
                        i -= 1;
                        j += 1;
                    }
                    break;
                case LB:
                    if (i == row - 1) {
                        direction = Direction.RT;
                        j += 1;
                    } else if (j == 0) {
                        direction = Direction.RT;
                        i += 1;
                    } else {
                        i += 1;
                        j -= 1;
                    }
                    break;
            }

            if (cnt == result.length) {
                break;
            }
        }
        return result;
    }

    static enum Direction {
        RT,
        LB
    }
}
