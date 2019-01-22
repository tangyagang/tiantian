package com.cssl.tiantian;

import com.cssl.tiantian.pojo.User;
import com.cssl.tiantian.service.user.UserService;
import com.cssl.tiantian.service.user.UserServiceImpl;
import com.cssl.tiantian.tools.Constants;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan("com.cssl.tiantian.dao")
public class TiantianApplication {

    public static void main(String[] args) {
        SpringApplication.run(TiantianApplication.class, args);
    }



}

