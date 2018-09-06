package com.isco.Blog.DataSource;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class SlaveAspect {
	
	public Logger logger=LoggerFactory.getLogger(SlaveAspect.class);
	
	/*
	 * 查询操作选择从数据库
	 * */
	@Before("execution(* com.isco.Blog.ServiceImpl.*ServiceImpl.select*(..))")
	public void setSlave() {
		DBContextHolder.setDBType(DBType.DB_TYPE_SLAVE);
	}

}
