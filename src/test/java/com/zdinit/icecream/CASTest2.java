package com.zdinit.icecream;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class CASTest2 {
    ReentrantLock lock = new ReentrantLock();
    private static AtomicInteger integer = new AtomicInteger(0);

    public void lock() {
        while ( !lock.tryLock() ){
//            System.out.println(Thread.currentThread().getName()+"获取失败");
        };
    }
    public void unlock(){
        lock.unlock();
    }

    public static void main(String[] args) {
        CASTest2 spinLock = new CASTest2();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true){
                    spinLock.lock();
                    try {
                        System.out.println(Thread.currentThread().getName() + "获取到了自旋锁");
                        Thread.sleep(new Random().nextInt(5)*500);
                        System.out.println(integer.incrementAndGet());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        System.out.println(Thread.currentThread().getName() + "释放了了自旋锁");
                        spinLock.unlock();
                    }
                }
            }
        };



        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(runnable);
        executorService.submit(runnable);


        executorService.shutdown();

    }
}

