package com.isco.Blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;



/**
 * @author sazhijie
 * time: 2018/9/6 10:00
 * 项目启动类
 *
 */
//核心注解，用于启动项目，该注解是一个组合注解
//具体组合了EnableAutoConfiguration、Configuration和ComponentScan
//但是为了使用主从同步技术了Redis，就需要exclude
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,RedisAutoConfiguration.class})
//开启Aspectj注解
@EnableAspectJAutoProxy
//开启缓存
@EnableCaching
//开启定时任务
@EnableScheduling
//扫描Mapper
@MapperScan("com.isco.Blog.Mapper")
public class BlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}
}
