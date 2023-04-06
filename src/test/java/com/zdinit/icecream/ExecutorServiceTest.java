package com.zdinit.icecream;

import org.apache.commons.lang3.time.DateUtils;
import org.openjdk.jol.util.MathUtil;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorServiceTest {


    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(20);
        Mq mq = new Mq();
        service.execute(new set(mq));
        service.execute(new set(mq));
        service.execute(new set(mq));
        service.execute(new set(mq));
        service.execute(new set(mq));

        service.execute(new sout(mq));
        service.execute(new sout(mq));
        service.execute(new sout(mq));
        service.execute(new sout(mq));
        service.execute(new sout(mq));

    }




}
class sout implements Runnable{
    Mq mq = null;
    sout(Mq mq){
        this.mq = mq;
    }

    @Override
    public void run() {
        while (true){
            mq.get();
        }

    }
}

class set implements Runnable{
    Mq mq = null;
    set(Mq mq){
        this.mq = mq;
    }

    @Override
    public void run() {
        while (true){
            mq.put();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class Mq {
    private List<Integer> stringList = new CopyOnWriteArrayList<>();

    private ConcurrentLinkedQueue<Integer> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();

    private AtomicInteger integer = new AtomicInteger(0);
    private Integer integer1 = new Integer(0);
    public void put(){
//        synchronized (Mq.class){
//            stringList.add(integer1++);
//        }

//        stringList.add(integer1++);

//        stringList.add(integer.incrementAndGet());
//        concurrentLinkedQueue.offer(integer1++);
        concurrentLinkedQueue.offer(integer.incrementAndGet());
    }
    public void get(){
//        synchronized (Mq.class){
//            if (stringList.size()>0) {
//                System.out.println(Thread.currentThread().getId()+" sout "+stringList.get(0));
//                stringList.remove(0);
//            }
//        }
        Integer integer = concurrentLinkedQueue.poll();
        if(integer!=null){
            System.out.println(Thread.currentThread().getId()+" sout "+integer);
        }

    }
}
