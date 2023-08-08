package com.zdinit.icecream;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//@SpringBootApplication //正常标签     使用sharing-jdbc标签 @SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class})
@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class})
public class IcecreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(IcecreamApplication.class, args);
	}

}
