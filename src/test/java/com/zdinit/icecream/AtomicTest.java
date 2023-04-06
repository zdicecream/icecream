package com.zdinit.icecream;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
@Slf4j
public class AtomicTest {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Integer integer = new Integer(0);
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        executorService.
        Sum sum = new Sum(integer);
        AtomiccSum atomiccSum = new AtomiccSum(atomicInteger);
//        for (int i = 0; i <5 ; i++) {
//            Thread thread = new Thread(sum);
//            thread.start();
//        }
//        for (int i = 0; i <5 ; i++) {
//            Thread thread = new Thread(atomiccSum);
//            thread.start();
//        }
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i <5 ; i++) {
            executorService.execute(atomiccSum);
        }
        log.info("AtomicInteger = {}",atomicInteger);
        log.info("Integer = {}",integer);
    }

}
@Slf4j
class Sum implements Runnable{
    Integer i;
    Sum(Integer integer){
        i= integer;
    }
    @Override
    public void run() {
        for (int j = 0; j <1000 ; j++) {
            i = i++;
        }
    }
}
@Slf4j
class AtomiccSum implements Runnable{
    AtomicInteger i;
    AtomiccSum(AtomicInteger integer){
        i= integer;
    }
    @Override
    public void run() {
        for (int j = 0; j <1000 ; j++) {
            i.incrementAndGet();
        }
    }
}