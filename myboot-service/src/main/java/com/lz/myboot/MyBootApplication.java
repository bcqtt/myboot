package com.lz.myboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan("com.lz.myboot.common.dao")
public class MyBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBootApplication.class, args);

	}
}