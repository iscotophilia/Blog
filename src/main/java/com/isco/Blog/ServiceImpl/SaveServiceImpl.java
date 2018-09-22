package com.isco.Blog.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.isco.Blog.Mapper.BlogMapper;
import com.isco.Blog.Mapper.SaveMapper;
import com.isco.Blog.POJO.Blog;
import com.isco.Blog.POJO.Save;
import com.isco.Blog.Service.SaveService;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW,isolation=Isolation.REPEATABLE_READ)
public class SaveServiceImpl implements SaveService {
	
	@Autowired
	private SaveMapper saveMapper;

	@Override
	public int cancelSave(int userId, int blogId) {
		Save save = new Save();
		save.setUserId(userId);
		save.setBlogId(blogId);
		if(saveMapper.selectByUserIdAndBlogId(save)==null)
			return 1;
		return saveMapper.deleteByUserIdAndBlogId(save);
	}
	
	
	/* 收藏
	 * @see com.isco.Blog.Service.BlogService#updateSave(int, int)
	 */
	@Override
	public int updateSave(int userId, int blogId) {
		Save save = new Save();
		save.setUserId(userId);
		save.setBlogId(blogId);
		if(saveMapper.selectByUserIdAndBlogId(save)!=null)
			return 1;
		return saveMapper.insert(save);
	}


}
