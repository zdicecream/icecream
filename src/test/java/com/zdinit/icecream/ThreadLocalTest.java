package com.zdinit.icecream;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalTest {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(5);
        threadLocal.set("a");
        executor.submit(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("b");
                System.out.println(threadLocal.get());
            }
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.submit(new Runnable() {
            @Override
            public void run() {

                System.out.println(threadLocal.get());
            }
        });
    }
}




