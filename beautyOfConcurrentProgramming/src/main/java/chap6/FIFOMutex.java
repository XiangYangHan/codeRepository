package chap6;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

public class FIFOMutex {

    private static final AtomicBoolean locked = new AtomicBoolean(false);
    private static final Queue<Thread> waiters = new ConcurrentLinkedQueue<>();

    public static void lock(Object blocker) {
        boolean wasInterrupted = false;
        Thread curThread = Thread.currentThread();
        waiters.add(curThread);

        while (waiters.element() != curThread || !locked.compareAndSet(false, true)) {
            LockSupport.park(blocker);
            if (Thread.interrupted()) {
                wasInterrupted = true;
            }
        }

        waiters.remove();
        if (wasInterrupted) {
            curThread.interrupt();
        }
    }

    public static void unlock() {
        locked.set(false);
        LockSupport.unpark(waiters.peek());
    }
}
