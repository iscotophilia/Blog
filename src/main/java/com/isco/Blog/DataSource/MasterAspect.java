package com.isco.Blog.DataSource;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect //定义切面
@Component
@Order(1)
public class MasterAspect {
	
	//用来生成日志监控
	public Logger logger=LoggerFactory.getLogger(MasterAspect.class);

	/*
	 * 增删改操作选择主数据库
	 * */
	@Before("execution(* com.isco.Blog.ServiceImpl.*ServiceImpl.*(..))")
	public void setMaster() {
		DBContextHolder.setDBType(DBType.DB_TYPE_MASTER);
	}

}
