package com.isco.Blog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isco.Blog.Service.SaveService;
@RestController
public class SaveController {
	
	@Autowired
	private SaveService saveService;
	
	/**
	 * 收藏
	 * @param userId
	 * @param blogId
	 * @return 1
	 */
	@RequestMapping(path="/saveBlog",method=RequestMethod.GET)
	public int saveBlog(int userId,int blogId) {
		return saveService.updateSave(userId, blogId);
	}
	
	/**
	 * 取消收藏
	 * @param userId
	 * @param blogId
	 * @return
	 */
	@RequestMapping(path="/cancelSaveBlog",method=RequestMethod.GET)
	public int cancelSaveBlog(int userId,int blogId) {
		return saveService.cancelSave(userId, blogId);
	}

}
