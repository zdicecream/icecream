package com.zdinit.icecream;

import org.openjdk.jol.info.ClassLayout;
import org.springframework.beans.factory.support.AbstractBeanFactory;

import java.util.concurrent.Executors;

public class ThreadTest {
    public static void main(String[] args) {
//        new ThreadTest().run2();
//        System.out.println(2 << 4);
//        System.out.println(1 << 30);
//        System.out.println(1 << 30 >>> 1);
//        Object O = new Object();
//        System.out.println();
//        StringBuilder stringBuilder = new StringBuilder();
//        StringBuffer stringBuffer = new StringBuffer();
        Executors.newFixedThreadPool(5);
    }

    public void run1(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <100 ; i++) {
                    if (Thread.currentThread().isInterrupted()){
                        System.out.println("out");
                        break;
                    }
                    System.out.println(i);
                }
            }
        });
        thread.start();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }

    public void run2(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <100 ; i++) {
//                    if (Thread.currentThread().isInterrupted()){
//                        System.out.println("out");
//                        break;
//                    }
                    if (i == 10){
                        Thread.currentThread().interrupt();
                        System.out.println("out");
                    }
                    System.out.println(i);
                }
            }
        });
        thread.start();
        synchronized (thread){
            try {
                thread.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        try {
            Thread.sleep(1);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
