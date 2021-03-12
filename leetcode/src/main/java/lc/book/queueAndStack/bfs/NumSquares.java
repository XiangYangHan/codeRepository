package lc.book.queueAndStack.bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class NumSquares {

    public static void main(String[] args) {
        NumSquares instance = new NumSquares();

        System.out.println(instance.numSquares(12));
        System.out.println(instance.numSquares(13));
        System.out.println(instance.numSquares(14));
        System.out.println(instance.numSquares(15));
        System.out.println(instance.numSquares(16));
        System.out.println(instance.numSquares(7168));
    }

    public int numSquares(int n) {
        int cnt = 1;
        List<Integer> squareNumList = new ArrayList<>();
        for (int i = 0, j = 0; (j = i * i) <= n; i++) {
            if (j == n) {
                return cnt;
            }
            squareNumList.add(j);
        }
        int[] squares = squareNumList.stream().mapToInt(Integer::intValue).toArray();

        // 保存n个平方数的和
        Queue<Integer> queue = new LinkedList<>(squareNumList);
        queue.offer(null);
        Set<Integer> visited = new HashSet<>(squareNumList);
        cnt++; // 平方数的个数

        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            if (cur == null) {
                if (queue.isEmpty()) {
                    break;
                } else {
                    cnt++;
                    queue.offer(null);
                }
            } else {
                for (int square : squares) {
                    int sum = cur + square; // 累加一个平方数
                    if (sum == n) {
                        return cnt;
                    } else if (sum > n) {
                        break;
                    } else if (visited.add(sum)) {
                        queue.offer(sum);
                    }
                }
            }
        }
        return 0;
    }
}
