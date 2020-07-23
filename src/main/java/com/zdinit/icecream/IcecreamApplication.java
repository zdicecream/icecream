package com.zdinit.icecream;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zdinit.icecream.*.mapper")
public class IcecreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(IcecreamApplication.class, args);
	}

}
