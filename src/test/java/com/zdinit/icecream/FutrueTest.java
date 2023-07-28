package com.zdinit.icecream;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FutrueTest {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        ExecutorService service = Executors.newFixedThreadPool(20);
        Integer res = 0;
//        List<Future<Integer>> futureList = new ArrayList<>();
//        for (int i = 0; i <2 ; i++) {
//            Future<Integer> futrue =  service.submit(new ta());
//            futureList.add(futrue);
//        }
//        stopWatch.start();
//        for (Future<Integer> f : futureList) {
//            try {
//                Integer a = f.get(2,TimeUnit.SECONDS);
//                System.out.println(a);
//                res = res+a;
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }catch (TimeoutException e) {
//                e.printStackTrace();
//            }
//        }

        List<task> tasks = new ArrayList<>();
        for (int i = 0; i <15 ; i++) {
            task futureTask = new task(new ta());
            service.submit(futureTask);
            tasks.add(futureTask);
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean a = false;
        for (task t:tasks) {
            try {
                t.get(2,TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }finally {
                a =true;
            }
        }
        if (a == true) {
            for (task t:tasks) {
                t.cancel(true);
            }
        }


        System.out.println("finsh");
        service.shutdown();
    }

}
class ta implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int a = RandomUtils.nextInt(1,10);
        Thread.sleep(a*1000);
        return a;
    }
}

class task extends FutureTask {
    public task(Callable callable) {
        super(callable);
    }

    @Override
    protected void done() {
        super.done();
    }
}