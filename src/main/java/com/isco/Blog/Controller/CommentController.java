package com.isco.Blog.Controller;

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
	@RequestMapping(path="/AddBlogComment",method=RequestMethod.POST)
	public Map<String, Object> addComment(@RequestBody Comment comment) {
		boolean b = false;
		Map<String, Object> map = new HashMap<>();
		if(comment!=null) {
			if(commentService.insert(comment)==1)
			{
				b=true;
			}
			map.put("result", b);
		}else {
			map.put("result", b);
		}
		return map;
	}
	//更改评论
	@RequestMapping(path="/UpdateComment",method=RequestMethod.POST)
	public Map<String, Object> updateComment(@RequestBody Comment comment) {
		boolean b = false;
		Map<String, Object> map = new HashMap<>();
		if(comment!=null) {
			if(commentService.updateByPrimaryKey(comment)==1)
			{
				b=true;
			}
			map.put("result", b);
		}else {
			map.put("result", b);
		}
		return map;
	}
	//删除评论
	@RequestMapping(path="/DelBlogComment",method=RequestMethod.DELETE)
	public Map<String, Object> delBlogComment(@RequestBody Map<String,Object> params) {
		boolean b = false;
		Map<String, Object> map = new HashMap<>();
		if(params.get("comid")!=null) {
			if(commentService.deleteByPrimaryKey(Integer.valueOf(params.get("comid").toString()))==1)
			{
				b=true;
			}
			map.put("result", b);
		}else {
			map.put("result", b);
		}
		return map;
	}
	//列出所有评论(传输参数待定)
	@RequestMapping(path="/ListAllComment",method=RequestMethod.GET)
	public Map<String, Object> ListComment() {
		boolean b = false;
		Map<String, Object> map = new HashMap<>();
		List<Comment> comments=commentService.selectAll();
		b=true;
		map.put("result", b);
		map.put("size", comments.size());
		for(int i=0;i<comments.size();i++)
		{
			map.put("Comment"+i, comments.get(i));			
		}
		return map;
	}
	//列出博客内评论
	@RequestMapping(path="/ListBlogComment",method=RequestMethod.GET)
	public Map<String, Object> ListBlogComment(@RequestBody Map<String,Object> params) {
		boolean b = false;
		Map<String, Object> map = new HashMap<>();
		int start=Integer.valueOf(params.get("start").toString());
		int size=Integer.valueOf(params.get("size").toString());
		if(params.get("blogid")!=null)
		{
			List<Comment> comments=commentService.selectAllByBlogID(Integer.valueOf(params.get("blogid").toString()),start,size);
			b=true;
			map.put("result", b);
			map.put("size", comments.size());
			for(int i=0;i<comments.size();i++)
			{
				map.put("bComment"+i, comments.get(i));			
			}
		}else {
			map.put("result", b);
		}
		return map;
	}
	//列出用户所有评论
	@RequestMapping(path="/ListUserComment",method=RequestMethod.GET)
	public Map<String, Object> ListUserComment(@RequestBody Map<String,Object> params) {
		boolean b = false;
		Map<String, Object> map = new HashMap<>();
		if(params.get("userid")!=null)
		{
			List<Comment> comments=commentService.selectAllByUserID(Integer.valueOf(params.get("userid").toString()));
			b=true;
			map.put("result", b);
			map.put("size", comments.size());
			for(int i=0;i<comments.size();i++)
			{
				map.put("uComment"+i, comments.get(i));			
			}
		}else {
			map.put("result", b);
		}
		return map;
	}
	//列出最受欢迎4条的评论
	@RequestMapping(path="/ListLoveComment",method=RequestMethod.GET)
	public Map<String, Object> ListLoveComment(@RequestBody Map<String,Object> params) {
		boolean b = false;
		Map<String, Object> map = new HashMap<>();
		if(params.get("blogid")!=null)
		{
			List<Comment> comments=commentService.selectAllByLove(Integer.valueOf(params.get("blogid").toString()));
			b=true;
			map.put("result", b);
			map.put("size", comments.size());
			for(int i=0;i<comments.size();i++)
			{
				map.put("uComment"+i, comments.get(i));			
			}
		}else {
			map.put("result", b);
		}
		return map;
	}

	//列出评论下回复
	@RequestMapping(path="/ListSubComment",method=RequestMethod.GET)
	public Map<String, Object> ListSubComment(@RequestBody Map<String,Object> params) {
		boolean b = false;
		Map<String, Object> map = new HashMap<>();
		if(params.get("comid")!=null)
		{
			List<Comment> comments=commentService.selectAllByParentID(Integer.valueOf(params.get("comid").toString()),Integer.valueOf(params.get("start").toString()),Integer.valueOf(params.get("size").toString()));
			b=true;
			map.put("result", b);
			map.put("size", comments.size());
			for(int i=0;i<comments.size();i++)
			{
				map.put("uComment"+i, comments.get(i));			
			}
		}else {
			map.put("result", b);
		}
		return map;
	}

}
