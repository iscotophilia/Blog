package com.isco.Blog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isco.Blog.Service.LoveService;

@RestController
public class LoveController {
	
	@Autowired
	private LoveService loveService;
	
	/**
	 * 点赞
	 * @param userId
	 * @param blogId
	 * @return 1
	 */
	@RequestMapping(path="/loveBlog",method=RequestMethod.GET)
	public int loveBlog(Integer userId,Integer blogId) {
		if(userId==null || blogId==null)
			return -1;
		return loveService.updateLove(userId, blogId);
	}
	
	/**
	 * 取消点赞
	 * @param userId
	 * @param blogId
	 * @return 1
	 */
	@RequestMapping(path="/cancelLoveBlog",method=RequestMethod.GET)
	public int cancelLoveBlog(Integer userId,Integer blogId) {
		if(userId==null || blogId==null)
			return -1;
		return loveService.cancelLove(userId, blogId);
	}

}
