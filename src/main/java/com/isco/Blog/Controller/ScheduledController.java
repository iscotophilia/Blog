package com.isco.Blog.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isco.Blog.ResultEntity.BlogUserEntity;
import com.isco.Blog.Service.ScheduledService;

/**
 * @author sazhijie
 * 创建时间 2018/9/27 11:18
 * 获取Top10用户列表和博客列表
 */
@RestController
public class ScheduledController {
	
	@Autowired
	private ScheduledService scheduledService;
	
	/**
	 * Top10博客
	 * @return
	 */
	@RequestMapping(path="/getTopList",method=RequestMethod.GET)
	public List<BlogUserEntity> getTopList(){
		return scheduledService.getTopList();
	}
	
	/**
	 * Top10用户
	 * @return
	 */
	@RequestMapping(path="/getTopUser",method=RequestMethod.GET)
	public List<Object> getTopUser(){
		return scheduledService.getTopUser();
	}

}
