package chap2;

public class P56_ThreadSafeInteger {

    private int value;

    public synchronized int getValue() {
        return value;
    }

    public synchronized P56_ThreadSafeInteger setValue(int value) {
        this.value = value;
        return this;
    }
}
