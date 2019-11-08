package com.sy.adminmodule.service.starter;

import com.sy.constant.AppConstant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(scanBasePackages = AppConstant.BASE_PACKAGE)
//用于暴露当前服务的dubbo配置文件
//如果当前项目不需要暴露给其它项目调用，可以不添加
@ImportResource({"classpath:xxx-deptmodule-provider.xml"})
public class Starter {
    public static void main(String[] args) {
        SpringApplication.run(Starter.class, args);
    }
}
