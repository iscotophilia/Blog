package com.isco.Blog.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isco.Blog.POJO.BlogGroup;
import com.isco.Blog.Service.BlogGroupService;

@RestController
public class BlogGroupController {

	@Autowired
	BlogGroupService blogGroupService;

	// 新建博客组（用户）
	@RequestMapping(path = "/addBlogGroup", method = RequestMethod.POST)
	public int addBlogGroup(@RequestBody BlogGroup bGroup) {
		if (bGroup.getName() == null || bGroup.getUserId() == null)
			return -2;
		return blogGroupService.insertGroup(bGroup);
	}

	// 更改博客组
	@RequestMapping(path = "/updateBlogGroup", method = RequestMethod.POST)
	public int updateBlogType(@RequestBody BlogGroup bGroup) {
		if (bGroup.getName() == null)
			return -2;
		return blogGroupService.updateGroupByPrimaryKey(bGroup);
	}

	// 删除博客组
	@RequestMapping(path = "/delBlogGroup", method = RequestMethod.DELETE)
	public int delBlogGroup(Integer id) {
		if(id==null)
			return -1;
		return blogGroupService.deleteGroupByPrimaryKey(id);
	}

	// 列出所有博客组和博客
	@RequestMapping(path = "/getBlogGroup", method = RequestMethod.GET)
	public List<BlogGroup> ListBlogType(Integer userId) {
		if(userId==null)
				return null;
		return blogGroupService.selectByUserId(userId);
	}

	// 列出所有博客组和博客
	@RequestMapping(path = "/getBlogGroupJustList", method = RequestMethod.GET)
	public List<BlogGroup> ListBlogTypeWithoutBlog(Integer userId) {
		if(userId==null)
			return null;
		return blogGroupService.selectByUserIdJustList(userId);
	}

}
