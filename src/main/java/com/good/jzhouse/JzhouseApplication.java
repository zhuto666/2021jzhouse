package com.good.jzhouse;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.good.jzhouse.dao"})
public class JzhouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(JzhouseApplication.class, args);
        System.out.println("wodetian");
    }

}
