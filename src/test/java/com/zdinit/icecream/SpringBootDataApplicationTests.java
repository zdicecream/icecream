package com.zdinit.icecream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class SpringBootDataApplicationTests {
//    @Autowired
//    DataSource dataSource;
    @Test
    void contextLoads() throws SQLException {
//        Connection connection = dataSource.getConnection();
//        //查看数据源
//        System.out.println(connection.getClass());
    }

}
