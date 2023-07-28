package com.zdinit.icecream;

public class Book {
    protected int get() {
        return 4 & 2;
    }

    public static void main(String[] args) {
        System.out.println(1 % 4);
        System.out.println(2 % 4);
        System.out.println(3 % 4);
        System.out.println(4 % 4);
        System.out.println(5 % 4);
    }
    private static long time() {
        return System.currentTimeMillis();
    }
}


