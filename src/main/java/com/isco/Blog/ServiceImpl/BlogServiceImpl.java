package com.isco.Blog.ServiceImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.isco.Blog.Mapper.BlogMapper;
import com.isco.Blog.Mapper.BlogTextMapper;
import com.isco.Blog.Mapper.BlogTypeMapper;
import com.isco.Blog.Mapper.FollowMapper;
import com.isco.Blog.Mapper.LoveMapper;
import com.isco.Blog.Mapper.SaveMapper;
import com.isco.Blog.Mapper.UserMapper;
import com.isco.Blog.POJO.Blog;
import com.isco.Blog.POJO.BlogText;
import com.isco.Blog.POJO.Follow;
import com.isco.Blog.POJO.Love;
import com.isco.Blog.POJO.Save;
import com.isco.Blog.Service.BlogService;

/**
 * 
 * @author 张硕
 *
 */
@EnableTransactionManagement
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW,isolation=Isolation.REPEATABLE_READ)
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogMapper blogMapper;
	
	@Autowired
	private BlogTextMapper blogTextMapper;
	
	@Autowired
	private LoveMapper loveMapper;
	
	@Autowired
	private SaveMapper saveMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private BlogTypeMapper blogTypeMapper;
	
	@Autowired
	private FollowMapper followMapper;

	//删除博客项目和内容
	//数据库内部有约束，删除博客主体对应内容也会删除
	@Override
	public int deleteByPrimaryKey(int id) {
		// TODO Auto-generated method stub
		return blogMapper.deleteByPrimaryKey(id);
	}

	//查询博客仅包括项目
	@Override
	public Blog selectByPrimaryKey(int id) {
		// TODO Auto-generated method stub
		return blogMapper.selectByPrimaryKey(id);
	}
	
	//列出单个用户博客项目
	@Override
	public List<Blog> selectOnes(int user_id) {
		// TODO Auto-generated method stub
		return null;//blogMapper.selectOnes(user_id);
	}
	//列出博客项目
	@Override
	public List<Blog> selectAll() {
		// TODO Auto-generated method stub
		return blogMapper.selectAll();
	}
	//更新博客项目不包括内容
	@Override
	public int updateByPrimaryKey(Blog record) {
		if(blogMapper.selectByPrimaryKey(record.getId())==null)
			return -1;
		return blogMapper.updateByPrimaryKey(record);
	}
	
	/* 查看所有博客，根据时间排序
	 * @see com.isco.Blog.Service.BlogService#selectByTime(int)
	 */
	@Override
	public Map<String,Object> selectByTime(int param,int page) {
		Map<String, Object> map = new HashMap<>();
		int count =blogMapper.selectCount();
		int i=CaculateParam(param, page,count);
		if(i<0) {
			map.put("result", false);
			return map;
		}
		map.put("result", true);
		map.put("blog", blogMapper.selectByTime(i,page));
		map.put("page",(int) Math.ceil((double)count/page));
		return map;
	}
	
	/* 查看所有博客，根据点赞数排序
	 * @see com.isco.Blog.Service.BlogService#selectByLove(int)
	 */
	@Override
	public Map<String,Object> selectByLove(int param,int page) {
		Map<String, Object> map = new HashMap<>();
		int count =blogMapper.selectCount();
		int i=CaculateParam(param, page,count);
		if(i<0) {
			map.put("result", false);
			return map;
		}
		
		map.put("result", true);
		map.put("blog", blogMapper.selectByLove(i,page));
		map.put("page",(int) Math.ceil((double)count/page));
		return map;
	}
	
	/* 查看用户自己的博客
	 * @see com.isco.Blog.Service.BlogService#selectByUserId(int, int, int)
	 */
	@Override
	public Map<String,Object> selectByUserId(int userId, int param, int page) {
		Map<String, Object> map = new HashMap<>();
		int count =blogMapper.selectByUserIdCount(userId);
		int i=CaculateParam(param, page,count);
		if(i<0) {
			map.put("result", false);
			return map;
		}
		System.out.println(i);
		map.put("result", true);
		map.put("blog", blogMapper.selectByUserId(userId,i,page));
		map.put("page",(int) Math.ceil((double)count/page));
		return map;
	}
	
	/* 查看用户关注的人的博客
	 * @see com.isco.Blog.Service.BlogService#selectByFollowId(int, int)
	 */
	@Override
	public Map<String,Object> selectByFollowId(int userId, int param,int page) {
		Map<String, Object> map = new HashMap<>();
		int count =blogMapper.selectByFollowIdCount(userId);
		int i=CaculateParam(param, page,count);
		if(i<0) {
			map.put("result", false);
			return map;
		}
		map.put("result", true);
		map.put("blog", blogMapper.selectByFollowId(userId, i, page));
		map.put("page",(int) Math.ceil((double)count/page));
		return map;
	}
	
	/* 查看用户点赞的博客
	 * @see com.isco.Blog.Service.BlogService#selectByUserIdAndLove(int, int, int)
	 */
	@Override
	public Map<String, Object> selectByUserIdAndLove(int userId, int param, int page) {
		Map<String, Object> map = new HashMap<>();
		int count =blogMapper.selectByUserIdAndLoveCount(userId);
		int i=CaculateParam(param, page,count);
		if(i<0) {
			map.put("result", false);
			return map;
		}
		map.put("result", true);
		map.put("blog", blogMapper.selectByUserIdAndLove(userId, i, page));
		map.put("page",(int) Math.ceil((double)count/page));
		return map;
	}

	/* 查看用户评论的博客
	 * @see com.isco.Blog.Service.BlogService#selectByUserIdAndComment(int, int, int)
	 */
	@Override
	public Map<String, Object> selectByUserIdAndComment(int userId, int param, int page) {
		Map<String, Object> map = new HashMap<>();
		int count =blogMapper.selectByUserIdAndCommentCount(userId);
		int i=CaculateParam(param, page,count);
		if(i<0) {
			map.put("result", false);
			return map;
		}
		map.put("result", true);
		map.put("blog", blogMapper.selectByUserIdAndComment(userId, i, page));
		map.put("page",(int) Math.ceil((double)count/page));
		return map;
	}

	

	/* 查看用户收藏的博客
	 * @see com.isco.Blog.Service.BlogService#selectByUserIdAndSave(int, int, int)
	 */
	@Override
	public Map<String, Object> selectByUserIdAndSave(int userId, int param, int page) {
		Map<String, Object> map = new HashMap<>();
		int count =blogMapper.selectByUserIdAndSaveCount(userId);
		int i =CaculateParam(param, page,count);
		if(i<0) {
			map.put("result", false);
			return map;
		}
		map.put("result", true);
		map.put("blog", blogMapper.selectByUserIdAndSave(userId, i, page));
		map.put("page",(int) Math.ceil((double)count/page));
		return map;
	}
	
	/**
	 * 校验输入页码与每一页的个数
	 * 格式是否正确
	 * @param param
	 * @param page
	 * @param count
	 * @return
	 */
	public int CaculateParam(int param,int page,int count) {
		System.out.println("param="+param+",page="+page+",count="+count);
		if(param<1 || page<1) {
			return -2;
		}
		param--;
		param *= page;
		if(param>count-1)
			return -1;
		return param;
	}
	
	/* 新建博客
	 * @see com.isco.Blog.Service.BlogService#insertBlog(java.lang.String, int, int, int, java.lang.String, java.lang.String, java.util.Date)
	 */
	@Override
	public int insertBlog(String title, int userId, int type, int group, String text,String path,Date date) {
		Blog blog = new Blog();
		blog.setBlogGroupId(group);
		blog.setBlogTypeId(type);
		blog.setTitle(title);
		blog.setUserId(userId);
		blog.setPic(path);
		blog.setTime(date);
		if(blogMapper.insert(blog)!=1) return -1;
		BlogText blogText = new BlogText();
		blogText.setBlogId(blog.getId());
		blogText.setText(text);
		return blogTextMapper.insert(blogText);
	}

	/* 根据类型来查看博客
	 * @see com.isco.Blog.Service.BlogService#selectByTimeWithType(int, int, int)
	 */
	@Override
	public Map<String, Object> selectByTimeWithType(int blogTypeId, int param, int page) {
		Map<String, Object> map = new HashMap<>();
		int count =blogMapper.selectByTimeWithTypeCount(blogTypeId);
		int i=CaculateParam(param, page,count);
		if(i<0) {
			map.put("result", false);
			return map;
		}
		map.put("result", true);
		map.put("blog", blogMapper.selectByTimeWithType(blogTypeId, i, page));
		map.put("page",(int) Math.ceil((double)count/page));
		return map;
	}

	/* 获取博客整体内容
	 * @see com.isco.Blog.Service.BlogService#selectBlogWhitText(int, int)
	 */
	@Override
	public Map<String, Object> selectBlogWhitText(int userId,int blogId) {
		Map<String,Object> map = new HashMap<>();
		Blog blog =  blogMapper.selectByPrimaryKey(blogId);
		map.put("blog", blog);
		map.put("blog_text", blogTextMapper.selectByBlogId(blogId));
		map.put("user", userMapper.selectByPrimaryKey(blog.getUserId()));
		map.put("type", blogTypeMapper.selectName(blog.getBlogTypeId()));
		Save save = new Save();
		save.setUserId(userId);
		save.setBlogId(blogId);
		map.put("isSave", false);
		if(saveMapper.selectByUserIdAndBlogId(save)!=null)
			map.put("isSave", true);
		Love love = new Love();
		love.setUserId(userId);
		love.setBlogId(blogId);
		map.put("isLove", false);
		if(loveMapper.selectByUserIdAndBlogId(love)!=null)
			map.put("isLove", true);
		return map;
	}

	@Override
	public Map<String, Object> selectByLike(String title, int param, int page) {
		Map<String, Object> map = new HashMap<>();
		int count =blogMapper.selectByLikeCount(title);
		int i=CaculateParam(param, page,count);
		if(i<0) {
			map.put("result", false);
			return map;
		}
		map.put("result", true);
		map.put("blog", blogMapper.selectByLike(title, i, page));
		map.put("page",(int) Math.ceil((double)count/page));
		return map;
	}

}
