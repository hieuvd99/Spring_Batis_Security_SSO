package com.greenfoarfece.smb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan("com.greenfoarfece.smb")
//@MapperScan(basePackages = "com.greenfoarfece.smb")
public class WebAppInitializer{

    public static void main(String[] args) throws Exception{
        SpringApplication.run(WebAppInitializer.class, args);
    }
}