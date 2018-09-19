package com.isco.Blog.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isco.Blog.Mapper.BlogMapper;
import com.isco.Blog.Mapper.LoveMapper;
import com.isco.Blog.POJO.Blog;
import com.isco.Blog.POJO.Love;
import com.isco.Blog.Service.LoveService;


/**
 * @author sazhijie
 * 创建时间 2018/9/19 9:17
 * 点赞功能实现
 *
 */
@Service
public class LoveServiceImpl implements LoveService {
	
	@Autowired
	private LoveMapper loveMapper;
	
	@Autowired
	private BlogMapper blogMapper;
	
	/* 点赞
	 */
	@Override
	public int updateLove(int userId, int blogId) {
		Love love = new Love();
		love.setUserId(userId);
		love.setBlogId(blogId);
		if(loveMapper.selectByUserIdAndBlogId(love)!=null)
			return 1;
		Blog blog = new Blog();
		blog.setId(blogId);
		blog.setLoveNum(1);
		blogMapper.updateByPrimaryKey(blog);
		return loveMapper.insert(love);
	}
	
	/* 取消赞
	 * @see com.isco.Blog.Service.LoveService#cancelLove(int, int)
	 */
	@Override
	public int cancelLove(int userId, int blogId) {
		Love love = new Love();
		love.setUserId(userId);
		love.setBlogId(blogId);
		loveMapper.deleteByUserIdAndBlogId(love);
		return 1;
	}

}
