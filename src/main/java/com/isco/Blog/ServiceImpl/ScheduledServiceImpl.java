package com.isco.Blog.ServiceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.isco.Blog.Mapper.BlogMapper;
import com.isco.Blog.Mapper.UserMapper;
import com.isco.Blog.ResultEntity.BlogUserEntity;
import com.isco.Blog.Service.ScheduledService;

/**
 * @author sazhijie
 * 创建时间 208/9/24 11:00
 * 定时获取Top10用户和博客
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW,isolation=Isolation.REPEATABLE_READ)
public class ScheduledServiceImpl implements ScheduledService {
	
	@Autowired
	private BlogMapper blogMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	/* 博客列表
	 * @see com.isco.Blog.Service.ScheduledService#getTopList()
	 */
	@Cacheable(value="toplist",key= "'scheduled_top_list'")
	@Override
	public List<BlogUserEntity> getTopList() {
		List<BlogUserEntity> list = blogMapper.selectByLove(0, 10);
		return list;
	}

	/* 缓存博客列表
	 * @see com.isco.Blog.Service.ScheduledService#setTopList()
	 */
	@CachePut(value="toplist",key="'scheduled_top_list'")
	@Scheduled(fixedDelay=300000)
	@Override
	public List<BlogUserEntity> setTopList() {
		List<BlogUserEntity> list = blogMapper.selectByLove(0, 10);
		return list;
	}

	/* 用户列表
	 * @see com.isco.Blog.Service.ScheduledService#getTopUser()
	 */
	@Cacheable(value="topuser",key= "'scheduled_top_user'")
	@Override
	public List<Object> getTopUser() {
		// TODO Auto-generated method stub
		return userMapper.selectTopUser();
	}

	/* 缓存用户列表
	 * @see com.isco.Blog.Service.ScheduledService#setTopUser()
	 */
	@CachePut(value="topuser",key="'scheduled_top_user'")
	@Scheduled(fixedDelay=300000)
	@Override
	public List<Object> setTopUser() {
		return userMapper.selectTopUser();
	}
	
}
