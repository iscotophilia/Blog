package com.isco.Blog.Service;

import java.util.List;
import java.util.Map;

import com.isco.Blog.POJO.User;
import com.isco.Blog.ResultEntity.BlogUserEntity;

public interface ScheduledService {
	
	List<BlogUserEntity> getTopList();
	
	List<BlogUserEntity> setTopList();
	
	List<Object> getTopUser();
	
	List<Object> setTopUser();

}
