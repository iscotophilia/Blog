package com.isco.Blog.ServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.isco.Blog.Mapper.BlogMapper;
import com.isco.Blog.Mapper.FollowMapper;
import com.isco.Blog.Mapper.SaveMapper;
import com.isco.Blog.Mapper.UserMapper;
import com.isco.Blog.ResultEntity.BlogUserEntity;
import com.isco.Blog.Service.ScheduledService;

@Service
public class ScheduledServiceImpl implements ScheduledService {
	
	@Autowired
	private BlogMapper blogMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Cacheable(value="toplist",key= "'scheduled_top_list'")
	@Override
	public List<BlogUserEntity> getTopList() {
		List<BlogUserEntity> list = blogMapper.selectByLove(0, 10);
		return list;
	}

	@CachePut(value="toplist",key="'scheduled_top_list'")
	@Scheduled(fixedDelay=300000)
	@Override
	public List<BlogUserEntity> setTopList() {
		List<BlogUserEntity> list = blogMapper.selectByLove(0, 10);
		return list;
	}

	@Cacheable(value="topuser",key= "'scheduled_top_user'")
	@Override
	public List<Object> getTopUser() {
		// TODO Auto-generated method stub
		return userMapper.selectTopUser();
	}

	@CachePut(value="topuser",key="'scheduled_top_user'")
	@Scheduled(fixedDelay=300000)
	@Override
	public List<Object> setTopUser() {
		return userMapper.selectTopUser();
	}
	
}
