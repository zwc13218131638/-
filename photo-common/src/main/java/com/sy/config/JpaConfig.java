package com.sy.config;

import com.sy.repository.factory.BaseRepositoryFactoryBean;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * SpringData配置信息
 */
@Configuration
//要扫描的持久层接口及其代理类生产工厂类
@EnableJpaRepositories(repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class, basePackages = {"com.sy.webmodule.dao", "com.sy.adminmodule.dao"})
//要扫描的实体类所在的包
@EntityScan(basePackages = "com.sy.entity")
public class JpaConfig {
}
