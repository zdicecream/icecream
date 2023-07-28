package com.zdinit.icecream;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class CASTest3 {
    private static AtomicInteger integer = new AtomicInteger(0);

    public static void main(String[] args) {
        CASTest3 spinLock = new CASTest3();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true){
                    synchronized (spinLock){
                        try {
                            System.out.println(Thread.currentThread().getName() + "获取到了自旋锁");
                            Thread.sleep(new Random().nextInt(5)*500);
                            System.out.println(integer.incrementAndGet());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            System.out.println(Thread.currentThread().getName() + "释放了了自旋锁");
                        }
                    }
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
        executorService.submit(runnable);
        executorService.submit(runnable);

        executorService.shutdown();

    }
}

