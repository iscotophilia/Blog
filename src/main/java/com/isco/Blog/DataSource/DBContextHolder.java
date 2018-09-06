package com.isco.Blog.DataSource;

public class DBContextHolder {
	
	private static ThreadLocal<String> contextHolder = new ThreadLocal<>();
	
	public static String getDBType() {
		String db = contextHolder.get();
		if(db == null)
			db = DBType.DB_TYPE_MASTER;
		return db;
	}
	
	public static void setDBType(String dbType) {
		contextHolder.set(dbType);
	}
	
	public static void clearDBType() {
		contextHolder.remove();
	}

}
