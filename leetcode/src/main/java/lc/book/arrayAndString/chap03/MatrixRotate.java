package lc.book.arrayAndString.chap03;

import java.util.Arrays;

/**
 * 题目描述：
 *      给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 *      不占用额外内存空间能否做到？
 *
 *      https://leetcode-cn.com/leetbook/read/array-and-string/clpgd/
 */
public class MatrixRotate {

    public static void main(String[] args) {
        int x = 1;
        int y = 2;
        x ^= y;
        y ^= x;
        x ^= y;
        System.out.println(x);
        System.out.println(y);
        MatrixRotate matrixRotate = new MatrixRotate();
        int[][] matrix = {{1}};
        System.out.println(Arrays.deepToString(matrixRotate.horizontalTurn(matrixRotate.LtRbTurn(matrix))));
        matrix = new int[][]{{1, 2}, {3, 4}};
        System.out.println(Arrays.deepToString(matrixRotate.horizontalTurn(matrixRotate.LtRbTurn(matrix))));
        matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.deepToString(matrixRotate.horizontalTurn(matrixRotate.LtRbTurn(matrix))));
//        System.out.println(Arrays.deepToString(matrixRotate.LtRbTurn(matrixRotate.horizontalTurn(matrix)))); // 必须先对角线翻转然后水平翻转
    }

    /*
        沿左上角至右下角的对角线（主对角线）翻转
        matrix[i][j] <=> matrix[j][i]
     */
    public int[][] LtRbTurn(int[][] matrix) {
        int l = matrix.length;
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                matrix[i][j] ^= matrix[j][i];
                matrix[j][i] ^= matrix[i][j];
                matrix[i][j] ^= matrix[j][i];
            }
        }
        return matrix;
    }

    /*
        水平翻转
        l = matrix.length;
        matrix[i][0] = matrix[i][l - 1 - 0];
        matrix[i][1] = matrix[i][l - 1 - 1];
        matrix[i][2] = matrix[i][l - 1 - 2];
     */
    public int[][] horizontalTurn(int[][] matrix) {
        int l = matrix.length;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < (l >> 1); j++) {
                matrix[i][j] ^= matrix[i][l - 1 - j];
                matrix[i][l - 1 - j] ^= matrix[i][j];
                matrix[i][j] ^= matrix[i][l - 1 - j];
            }
        }
        return matrix;
    }

}
