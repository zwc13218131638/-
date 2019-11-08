package com.sy.webmodule.starter;

import com.sy.constant.AppConstant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(scanBasePackages = AppConstant.BASE_PACKAGE)
//消费方
@ImportResource({"classpath:dubbo-webmodule-consumer.xml"})
public class Starter {
    public static void main(String[] args) {
        SpringApplication.run(Starter.class, args);
    }
}
