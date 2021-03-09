package lc.book.queueAndStack.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WallsAndGates {

    public static int[][] T_R_B_L = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        WallsAndGates instance = new WallsAndGates();
        int[][] rooms = {
                {2147483647, -1, 0, 2147483647},
                {2147483647, 2147483647, 2147483647, -1},
                {2147483647, -1, 2147483647, -1},
                {0, -1, 2147483647, 2147483647}
        };
        instance.wallsAndGates(rooms);
        System.out.println(Arrays.deepToString(rooms));
    }

    public void wallsAndGates(int[][] rooms) {
        Map<String, int[]> map = new HashMap<>();
        Queue<int[]> cells = new LinkedList<>();
        for (int r = 0; r < rooms.length; r++) {
            for (int c = 0; c < rooms[r].length; c++) {
                if (rooms[r][c] == 0) {
//                    cells.offer(coordinateOf(r, c));
                    cells.add(new int[]{r, c});
                }
            }
        }
        cells.offer(null);
        int instance = 1;
        while (!cells.isEmpty()) {
            int[] cur = cells.poll();
            if (cur == null) {
                if (cells.isEmpty()) {
                    break;
                } else {
                    cells.offer(null);
                    instance++;
                    continue;
                }
            }
            for (int[] trbl : T_R_B_L) {
                int r = cur[0] + trbl[0];
                int c = cur[1] + trbl[1];
                if (r < 0 || r == rooms.length
                        || c < 0 || c == rooms[r].length
                        || rooms[r][c] != Integer.MAX_VALUE) {
                    continue;
                }
                rooms[r][c] = instance;
//                cells.offer(coordinateOf(r, c));
                cells.add(new int[]{r, c});
            }
        }

    }


    public static Map<String, int[]> map = new HashMap<>();
    public static int[] coordinateOf(int row, int col) {
        String s = row + "-" + col;
        return map.computeIfAbsent(s, k -> new int[]{row, col});
    }
}
