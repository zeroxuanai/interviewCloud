package com.yangjian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.context.annotation.ApplicationScope;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * ClassName : ${NAME}
 * Package : com.yangjian
 * Description :
 *
 * @author : zeroXuan
 * @version : V1.0.0
 */
@SpringBootApplication
@MapperScan("com.yangjian.mapper")
public class Main {
    public static void main(String[] args) {

        SpringApplication.run(Main.class,args);
    }
}