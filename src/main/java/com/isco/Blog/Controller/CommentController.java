package com.isco.Blog.Controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.isco.Blog.POJO.Blog;
import com.isco.Blog.POJO.BlogGroup;
import com.isco.Blog.POJO.Comment;
import com.isco.Blog.POJO.User;
import com.isco.Blog.Service.CommentService;

/**
 * 
 * @author 张硕
 *
 */
class Param1{
	Blog blog;
	int start;
	int size;
}
@RestController
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	//添加新的评论
	@RequestMapping(path="/addBlogComment",method=RequestMethod.POST)
	public int addComment(@RequestBody Comment comment) {
		if(comment.getBlogId()==null ||comment.getUserId()==null || comment.getComment()==null)
			return -1;
		comment.setTime(new Date());
		return commentService.insert(comment);
	}
	//更改评论
	@RequestMapping(path="/updateComment",method=RequestMethod.POST)
	public int updateComment(@RequestBody Comment comment) {
		if(comment.getId()==null || comment.getComment()==null)
			return -1;
		return commentService.updateByPrimaryKey(comment);
	}
	//删除评论
	@RequestMapping(path="/delBlogComment",method=RequestMethod.DELETE)
	public int delBlogComment(Integer id) {
		if(id==null)
			return -1;
		return commentService.deleteByPrimaryKey(id);
	}
	//列出所有评论
	@RequestMapping(path="/listAllComment",method=RequestMethod.GET)
	public List<Object> ListComment(Integer start) {
		if(start==null)
			return null;
		return commentService.selectAll(start);
	}
	//列出博客内评论
	@RequestMapping(path="/listBlogComment",method=RequestMethod.GET)
	public List<Object> ListBlogComment(Integer  blogId,Integer start) {
		if(blogId==null || start==null)
			return null;
		return commentService.selectAllByBlogID(blogId,start);

	}
	//列出用户所有评论
	@RequestMapping(path="/listUserComment",method=RequestMethod.GET)
	public List<Object> ListUserComment(Integer userId,Integer start) {
		if(userId==null || start==null)
			return null;
		return commentService.selectAllByUserID(userId,start);
	}

	//列出评论下回复
	@RequestMapping(path="/listSubComment",method=RequestMethod.GET)
	public List<Object> ListSubComment(Integer id,Integer start) {
		if(id==null || start==null)
			return null;
		return commentService.selectAllByParentID(id,start);
	}

}
