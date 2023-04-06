package com.zdinit.icecream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

import java.util.concurrent.atomic.AtomicLong;

@Slf4j
public class StringTest {
    public static void main(String[] args) {
        StringTest test = new StringTest();
        test.s4();
        test.s3();
        test.s2();
        test.s1();
    }

    public void s1(){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i <99999 ; i++) {
            stringBuffer.append("12");
            stringBuffer.append("("+"ab"+")");
        }
        stringBuffer.toString();
        stopWatch.stop();
        log.info("s1 total : {}",stopWatch.getTotalTimeNanos());
    }
    public void s2(){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i <99999 ; i++) {
            stringBuffer.append("23");
            stringBuffer.append("(cd)");
        }
        stringBuffer.toString();
        stopWatch.stop();
        log.info("s2 total : {}",stopWatch.getTotalTimeNanos());
    }
    public void s3(){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i <99999 ; i++) {
            stringBuffer.append("56");
            stringBuffer.append("("+"ef"+")");
        }
        stringBuffer.toString();
        stopWatch.stop();
        log.info("s3 total : {}",stopWatch.getTotalTimeNanos());
    }
    public void s4(){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i <99999 ; i++) {
            stringBuffer.append("78");
            stringBuffer.append("(gh)");
        }
        stringBuffer.toString();
        stopWatch.stop();
        log.info("s4 total : {}",stopWatch.getTotalTimeNanos());
    }
}
