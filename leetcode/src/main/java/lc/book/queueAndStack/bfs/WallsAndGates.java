package lc.book.queueAndStack.bfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public class WallsAndGates {

    public static void main(String[] args) {
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
        for (int r = 0; r < rooms.length; r++) {
            for (int c = 0; c < rooms[r].length; c++) {
                if (rooms[r][c] == 0) {
                    Queue<Coordinate> queue = new LinkedList<>();
                    Set<Coordinate> set = new HashSet<>();
                    int distance = 0;
                    Coordinate coordinate = new Coordinate(r, c);
                    coordinate.rooms = rooms;
                    queue.offer(coordinate);
                    queue.offer(null);
                    set.add(coordinate);
                    set.add(null);
                    while (!queue.isEmpty()) {
                        Coordinate p = queue.poll();
                        if (Objects.isNull(p)) {
                            distance++;
                            if (queue.isEmpty()) {
                                break;
                            } else {
                                queue.offer(null);
                                continue;
                            }
                        }
                        if (p.retrieve() > distance) {
                            p.setDistance(distance);
                            // 扩充一圈，把新路径入队
                            Coordinate side;
                            if (set.add(side = p.top()) && side.retrieve() > 0) {
                                queue.offer(side);
                            }
                            if (set.add(side = p.left()) && side.retrieve() > 0) {
                                queue.offer(side);
                            }
                            if (set.add(side = p.bottom()) && side.retrieve() > 0) {
                                queue.offer(side);
                            }
                            if (set.add(side = p.right()) && side.retrieve() > 0) {
                                queue.offer(side);
                            }
                        }
                    }
                }
            }
        }
    }

    static class Coordinate {
        Set<int[]> set = new HashSet<>();
        int row;
        int col;

        int[][] rooms;

        public Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return row == that.row && col == that.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }

        public int retrieve() {
            return rooms[row][col];
        }

        public void setDistance(int distance) {
            rooms[row][col] = distance;
        }

        public Coordinate top() {
            return  overflowBeNull(row - 1, col);
        }

        public Coordinate bottom() {
            return  overflowBeNull(row + 1, col);
        }

        public Coordinate left() {
            return  overflowBeNull(row, col - 1);
        }

        public Coordinate right() {
            return  overflowBeNull(row, col + 1);
        }

        public Coordinate overflowBeNull(int row, int col) {
            int rows = rooms.length;
            int cols = rooms[this.row].length;
            if (row < 0 || row >= rows || col < 0 || col >= cols) {
                return null;
            } else {
                Coordinate coordinate = new Coordinate(row, col);
                coordinate.rooms = this.rooms;
                return coordinate;
            }
        }
    }
}
