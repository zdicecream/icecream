package com.zdinit.icecream;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.sql.SQLException;

@Slf4j
@SpringBootTest
public class redisTest {
    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    void contextLoads() throws SQLException {
        redisTemplate.opsForList().leftPush("list",1);
        log.info(String.valueOf(redisTemplate.opsForList().range("list",0,9)));
    }
}
