package lc.book.queueAndStack;

public class MovingAverage {

    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println(movingAverage.next(1));
        System.out.println(movingAverage.next(10));
        System.out.println(movingAverage.next(3));
        System.out.println(movingAverage.next(5));
    }

    private int[] data;
    private int head;
    private int sum;
    private int count;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        data = new int[size];
    }

    public double next(int val) {
        sum += val;
        sum -= data[head];
        data[head] = val;
        head++;
        if (head == data.length) {
            head = 0;
        }
        if (count < data.length) {
            count++;
        }
        return sum / (double) count;
    }
}
