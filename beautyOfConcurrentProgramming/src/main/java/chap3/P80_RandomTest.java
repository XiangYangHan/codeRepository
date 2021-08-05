package chap3;

import java.util.Random;

public class P80_RandomTest {

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random(); // 随机数生成器，使用默认种子(seed)

        for (int i = 0; i < 1; i++) {
            random.nextInt();
            System.out.println(random.nextInt(5)); // [0, bound) 之间的随机数
        }
    }
}
