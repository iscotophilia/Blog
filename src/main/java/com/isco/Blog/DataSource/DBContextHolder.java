package com.isco.Blog.DataSource;

/**
 * @author sazhijie
 * time 2018/9/6 17:03
 * 设置主从数据库
 *
 */
public class DBContextHolder {
	
	private static ThreadLocal<String> contextHolder = new ThreadLocal<>();
	
	//获得当前数据库
	public static String getDBType() {
		String db = contextHolder.get();
		if(db == null)
			db = DBType.DB_TYPE_MASTER;
		return db;
	}
	
	//设置数据库
	public static void setDBType(String dbType) {
		contextHolder.set(dbType);
	}
	
	//清除数据库
	public static void clearDBType() {
		contextHolder.remove();
	}

}
