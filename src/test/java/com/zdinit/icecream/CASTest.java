package com.zdinit.icecream;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CASTest {
    /**
     * 锁的持有者
     */
    private AtomicReference<Thread> owner = new AtomicReference<>();

    /**
     * 记录锁重入次数
     */
    private volatile int count = 0;

    public void lock() {
        Thread current = Thread.currentThread();
        // 当前线程已经持有锁, 则记录重入次数即可
        if( current == owner.get() ) {
            count++;
            return;
        }

        while ( !owner.compareAndSet(null, current) );
    }

    public void unlock() {
        Thread current = Thread.currentThread();
        if( current == owner.get() ) {
            if( count>0 ) {
                // 锁重入, 直接自减即可
                count--;
            } else {
                owner.set(null);
            }
        }
    }

    public static void main(String[] args) {
        CASTest spinLock = new CASTest();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "开始尝试获取自旋锁");
                spinLock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + "获取到了自旋锁");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    spinLock.unlock();
                    System.out.println(Thread.currentThread().getName() + "释放了了自旋锁");
                }
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(runnable);
        executorService.submit(runnable);
        executorService.submit(runnable);
        executorService.submit(runnable);
        executorService.submit(runnable);
        executorService.submit(runnable);

    }
}

