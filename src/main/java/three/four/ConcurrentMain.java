package three.four;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentMain {
    volatile int count = 0;
    private AtomicBoolean atomicBoolean = new AtomicBoolean(false);
    AtomicInteger count1 = new AtomicInteger(2);


    ReentrantLock lockA = new ReentrantLock();
    ReentrantLock lockB = new ReentrantLock();

    public static void main(String[] strings) throws InterruptedException {
        ConcurrentMain concurrentMain = new ConcurrentMain();
        List<Thread> threads = new ArrayList<>();


        for(int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> concurrentMain.increment());
            threads.add(thread);
            thread.start();
        }

        for(Thread thread : threads) {
            thread.join();
        }

        System.out.println(concurrentMain.count);

    }

    void increment() {
        for (int i = 0; i < 1000; i++) {
            safeIncrement();
        }
    }


    void safeIncrement() {
        while (true) {
            if (atomicBoolean.compareAndSet(false, true)) {
                count++;
                atomicBoolean.set(false);
                break;
            }
        }
    }

    void method1() {
        job1();
    }

    void method2() {
        job2();
    }

    void job1() {
        lockA.lock();
    }

    void job2() {

    }
}
