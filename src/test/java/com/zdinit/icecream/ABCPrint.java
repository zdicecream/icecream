package com.zdinit.icecream;

import org.apache.commons.lang3.RandomUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ABCPrint {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        Flag flag = new Flag();
        service.submit(new ABC("A",flag));
        service.submit(new ABC("B",flag));
        service.submit(new ABC("C",flag));
        service.submit(new ABC("B",flag));
        service.submit(new ABC("B",flag));
        service.submit(new ABC("B",flag));
        service.submit(new ABC("B",flag));
        service.submit(new ABC("B",flag));

    }
}

class ABC implements Runnable {
    String s;
    Flag flag;

    public ABC(String s1,Flag flag1){
        s = s1;
        flag = flag1;
    }

    @Override
    public void run() {
        while (true){
            if(flag.f.equals(s)){
                System.out.println(Thread.currentThread().getName()+" "+s);
                flag.setF();
            }
            try {
                Thread.sleep(RandomUtils.nextInt(1,5)*500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Flag {
    String f = "A";

    public void setF() {
        if (f.equals("A")){
            this.f = "B";
        }else if (f.equals("B")){
            this.f = "C";
        }else {
            this.f = "A";
        }

    }
}
