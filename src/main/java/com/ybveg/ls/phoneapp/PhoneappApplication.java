package com.ybveg.ls.phoneapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@SpringBootApplication
public class PhoneappApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhoneappApplication.class, args);
        System.out.println("启动成功！");
    }

}
