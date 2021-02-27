package lc.book.queueAndStack;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {

    private Queue<Integer> data;
    private int count;

    private int sum;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.data = new LinkedList<>();
        this.count = size;
    }

    public double next(int val) {
        data.offer(val);
        sum += val;
        if (data.size() > count) {
            sum -= data.poll();
        }
        return ((double) sum) / data.size();
    }
}
