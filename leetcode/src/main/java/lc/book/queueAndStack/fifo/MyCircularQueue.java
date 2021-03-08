package lc.book.queueAndStack.fifo;

public class MyCircularQueue {
    private int[] data;
    private int size; // 队列中元素的个数
    private int head; // 下次出队元素的下标，时刻维持有效队首
    private int tail; // 上次入队元素的下标，时刻维持有效对尾

    public MyCircularQueue(int k) {
        data = new int[k];
        tail = -1; // 从未进行入队操作，取 -1
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        size++;
        tail++; // 计算新入队元素下标
        if (tail == data.length) tail = 0;
        data[tail] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        size--;
        head++; // 计算下次出队元素下标
        if (head == data.length) head = 0;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        } else {
            return data[head];
        }
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        } else {
            return data[tail];
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == data.length;
    }
}
