package com.zdinit.icecream;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadPoolExecutor;
@Slf4j
@SpringBootTest
class SpringBootDataApplicationTests {
//    @Autowired
//    DataSource dataSource;
    @Autowired
    private AsynTaskService asynTaskService;
    @Test
    void contextLoads() throws SQLException {
//        Connection connection = dataSource.getConnection();
//        //查看数据源
//        System.out.println(connection.getClass());

//        for (int i = 0; i <10 ; i++) {
//            asynTaskService.f1();
//            asynTaskService.f2();
//        }
//        asynTaskService.f1();
//        asynTaskService.f2();
//        log.info("this is {}",Thread.currentThread().getId());


//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor()
//        Thread thread = new Thread();
//        thread.interrupt();
//        Thread.currentThread().interrupt();
//        Map map = new HashMap<>();
        System.out.println(1 << 30);

    }





}
