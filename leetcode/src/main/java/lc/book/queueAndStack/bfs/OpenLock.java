package lc.book.queueAndStack.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenLock {

    public static void main(String[] args) {
        OpenLock instance = new OpenLock();
        String[] deadends = new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        String target = "8888";
        System.out.println(instance.openLock(deadends, target));
        System.out.println(instance.openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));

    }

    public int openLock(String[] deadends, String target) {
        String cur = "0000";
        Set<String> visited = new HashSet<>();
        for (String deadend : deadends) {
            if (cur.equals(deadend)) {
                return -1;
            }
            visited.add(deadend);
        }

        int cnt = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(cur);
        queue.offer(null);
        visited.add(cur);
        
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (cur == null) {
                if (queue.isEmpty()) {
                    break;
                } else {
                    cnt++;
                    queue.offer(null);
                }
            } else if (cur.equals(target)) {
                return cnt;
            } else {
                // 处理旋转
                for (int i = 0; i < 4; i++) {
                    String turned = plusOne(cur, i);
                    if (visited.add(turned)) {
                        queue.offer(turned);
                    }
                    turned = minusOne(cur, i);
                    if (visited.add(turned)) {
                        queue.offer(turned);
                    }
                }
            } 
        }
        return -1;
    }

    private String minusOne(String cur, int i) {
        char[] chars = cur.toCharArray();
        if (chars[i] == '0') {
            chars[i] = '9';
        } else {
            chars[i]--;
        }
        return new String(chars);
    }

    private String plusOne(String cur, int i) {
        char[] chars = cur.toCharArray();
        if (chars[i] == '9') {
            chars[i] = '0';
        } else {
            chars[i]++;
        }
        return new String(chars);
    }
}
