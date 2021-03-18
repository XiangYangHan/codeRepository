package chap2;

public class P56_ThreadNotSafeInteger {

    private int value;

    public int getValue() {
        return value;
    }

    public P56_ThreadNotSafeInteger setValue(int value) {
        this.value = value;
        return this;
    }
}
