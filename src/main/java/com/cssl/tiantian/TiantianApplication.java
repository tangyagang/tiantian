package com.cssl.tiantian;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cssl.tiantian.dao")
public class TiantianApplication {

    public static void main(String[] args) {
        SpringApplication.run(TiantianApplication.class, args);
    }

}

