package chap2;

public class P56_ThreadSafeIntegerUseVolatile {

    volatile private int value;

    public int getValue() {
        return value;
    }

    public P56_ThreadSafeIntegerUseVolatile setValue(int value) {
        this.value = value;
        return this;
    }

}
