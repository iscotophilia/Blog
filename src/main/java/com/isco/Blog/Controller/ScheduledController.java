package com.isco.Blog.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isco.Blog.ResultEntity.BlogUserEntity;
import com.isco.Blog.Service.ScheduledService;

@RestController
public class ScheduledController {
	
	@Autowired
	private ScheduledService scheduledService;
	
	@RequestMapping(path="/getTopList",method=RequestMethod.GET)
	public List<BlogUserEntity> getTopList(){
		return scheduledService.getTopList();
	}
	
	@RequestMapping(path="/getTopUser",method=RequestMethod.GET)
	public List<Object> getTopUser(){
		return scheduledService.getTopUser();
	}

}
