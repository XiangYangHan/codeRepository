package chap2;

public class P57_ThreadNotSafeCount {

    private long value;

    public long getValue() {
        return value;
    }

    public long inc() {
        return ++value;
    }
}
