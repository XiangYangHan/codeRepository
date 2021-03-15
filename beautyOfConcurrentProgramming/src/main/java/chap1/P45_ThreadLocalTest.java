package chap1;

public class P45_ThreadLocalTest {

//    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public static ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        threadLocal.set("Hello, world.");
        Thread t = new Thread(() -> {
            // 若为ThreadLocal实例，子线程中无法获取父线程设置的 ThreadLocal 值
            // 若为InheritableThreadLocal实例，子线程中可以获取父线程设置的 ThreadLocal 值
            System.out.println("thread: " + threadLocal.get());
        });

        t.start();
//        Thread.sleep(1);
        System.out.println("main thread: " + threadLocal.get());
    }
}
