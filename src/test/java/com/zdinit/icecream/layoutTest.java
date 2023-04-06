package com.zdinit.icecream;

import org.openjdk.jol.info.ClassLayout;

public class layoutTest {
    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        synchronized (o){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }
}
