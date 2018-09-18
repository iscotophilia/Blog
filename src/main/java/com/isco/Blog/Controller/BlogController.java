package com.isco.Blog.Controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.isco.Blog.Mapper.BlogMapper;
import com.isco.Blog.POJO.Blog;
import com.isco.Blog.ResultEntity.BlogUserEntity;
import com.isco.Blog.Service.BlogService;

/**
 * 
 * @author 张硕
 *
 */
@RestController
public class BlogController {

	@Autowired
    private BlogService blogService;
	
	/**
	 * 新建博客
	 * @param file
	 * @param title
	 * @param userId
	 * @param type
	 * @param group
	 * @param text
	 * @return
	 */
	@RequestMapping(path="/addBlog",method=RequestMethod.POST)
	public int addBlog(@RequestParam(name="file",required=false) MultipartFile file,
			@RequestParam("title")String title,@RequestParam("userId") int userId,
			@RequestParam("type") int type,@RequestParam("group") int group,
			@RequestParam("text") String text) {
		
		String path=null;
		Date date = new Date();
		if(file!=null) {
			String name = file.getOriginalFilename();
			String b = name.substring(name.lastIndexOf(".") + 1);
			path = "/var/www/html/blogimg/"+date.toString()+userId+"."+b;
			try {
				FileUtils.writeByteArrayToFile(new File(path), file.getBytes());
			} catch (IOException e) {
				return -1;
			}
		}
		return blogService.insertBlog(title, userId, type, group, text, path,date);
	}


	//删除博客项目
	@RequestMapping(path="/delBlog",method=RequestMethod.DELETE)
	public int DelBlog(int id) {
		if(blogService.selectByPrimaryKey(id)!=null)
			return blogService.deleteByPrimaryKey(id);
		return -1;
	}
	
	//更新博客
	@RequestMapping(path="/updateBlog",method=RequestMethod.POST)
	public int UpdateBlog(@RequestBody Blog blog) {
		return blogService.updateByPrimaryKey(blog);
	}
	
	/**
	 * 请求获取博客列表根据时间
	 * @param param
	 * @return
	 * 返回博客信息和用户信息
	 */
	@RequestMapping(path="getBlogWithTime",method=RequestMethod.GET)
	public Map<String, Object> getBlogWithTime(int param,int page){
		return blogService.selectByTime(param, page);
	}
	
	
	/**
	 * 获取热度最高的博客
	 * @param param
	 * @return
	 */
	@RequestMapping(path="getBlogWithLove",method=RequestMethod.GET)
	public Map<String,Object> getBlogWithLove(int param,int page){
		return blogService.selectByLove(param,page);
	}
	
	/**
	 * 获取用户关注的人的博客
	 * 根据时间排序
	 * @param userId
	 * @param param
	 * @return
	 */
	@RequestMapping(path="/getFollowBlog",method=RequestMethod.GET)
	public Map<String,Object> getFollowBlog(int userId,int param,int page){
		return blogService.selectByFollowId(userId, param, page);
	}
	
	/**
	 * 获取用户的博客
	 * 根据时间排序
	 * @param userId
	 * @param param
	 * @return
	 */
	@RequestMapping(path="/getUserBlog",method=RequestMethod.GET)
	public Map<String,Object> getUserBlog(int userId,int param,int page){
		return blogService.selectByUserId(userId, param, page);
	}
	
	/**
	 * 点赞
	 * @param userId
	 * @param blogId
	 * @return 1
	 */
	@RequestMapping(path="/loveBlog",method=RequestMethod.GET)
	public int loveBlog(int userId,int blogId) {
		return blogService.updateLove(userId, blogId);
	}
	
	/**
	 * 收藏
	 * @param userId
	 * @param blogId
	 * @return 1
	 */
	@RequestMapping(path="/saveBlog",method=RequestMethod.GET)
	public int saveBlog(int userId,int blogId) {
		return blogService.updateSave(userId, blogId);
	}
	
	
	/**
	 * 获取用户点赞的博客
	 * @param userId
	 * @param param
	 * @param page
	 * @return
	 */
	@RequestMapping(path="getLoveBlog",method=RequestMethod.GET)
	public Map<String,Object> getLoveBlog(int userId,int param,int page) {
		return blogService.selectByUserIdAndLove(userId, param, page);
	}
	
	
	
	/**
	 * 获取用户评论过的博客
	 * @param userId
	 * @param param
	 * @param page
	 * @return
	 */
	@RequestMapping(path="getCommentBlog",method=RequestMethod.GET)
	public Map<String,Object> getCommentBlog(int userId,int param,int page) {
		return blogService.selectByUserIdAndComment(userId, param, page);
	}
	
	
	/**
	 * 获取用户收藏过的博客
	 * @param userId
	 * @param param
	 * @param page
	 * @return
	 */
	@RequestMapping(path="getSaveBlog",method=RequestMethod.GET)
	public Map<String,Object> getSaveBlog(int userId,int param,int page) {
		return blogService.selectByUserIdAndSave(userId, param, page);
	}
	
	/**
	 * 根据博客类型来查询博客
	 * @param blogTypeId
	 * @param param
	 * @param page
	 * @return
	 */
	@RequestMapping(path="getTypeBlog",method=RequestMethod.GET)
	public Map<String,Object> getTypeBlog(int blogTypeId,int param,int page){
		return blogService.selectByTimeWithType(blogTypeId, param, page);
	}
	
	/**
	 * 获取博客内容
	 * @param userId
	 * @param blogId
	 * @return
	 */
	@RequestMapping(path="/getBlog",method=RequestMethod.GET)
	public Map<String,Object> getBlog(int userId,int blogId){
		return blogService.selectBlogWhitText(userId, blogId);
	}
}
