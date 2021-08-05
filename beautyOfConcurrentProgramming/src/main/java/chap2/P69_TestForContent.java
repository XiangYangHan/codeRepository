package chap2;

public class P69_TestForContent {

    static final int len = 10000;

    public static void main(String[] args) {
        long[][] arr = new long[len][len];

        long start = System.currentTimeMillis();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                arr[i][j] = i * 2 + j;
            }
        }
        long expend = System.currentTimeMillis() - start;
        System.out.println("expend time: " + expend);

        start = System.currentTimeMillis();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                arr[j][i] = i * 2 + j;
            }
        }
        expend = System.currentTimeMillis() - start;
        System.out.println("expend time: " + expend);
    }
}
