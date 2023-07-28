package com.zdinit.icecream;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTest {

    public static void main(String[] args) {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh-mm-ss"));
        System.out.println(date);

        String date2 = LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(date2);


    }
}

class dateThead implements Runnable {

    @Override
    public void run() {

    }
}


