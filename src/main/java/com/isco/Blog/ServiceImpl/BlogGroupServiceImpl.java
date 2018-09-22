package com.isco.Blog.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.isco.Blog.Mapper.BlogGroupMapper;
import com.isco.Blog.Mapper.BlogMapper;
import com.isco.Blog.POJO.BlogGroup;
import com.isco.Blog.Service.BlogGroupService;
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW,isolation=Isolation.REPEATABLE_READ)
public class BlogGroupServiceImpl implements BlogGroupService {

	@Autowired
	private BlogGroupMapper blogGroupMapper;
	//删除博客组
	@Override
	public int deleteGroupByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		if(blogGroupMapper.selectByPrimaryKey(id)==null)
			return -1;
		return blogGroupMapper.deleteByPrimaryKey(id);
	}
	//插入博客组
	@Override
	public int insertGroup(BlogGroup record) {
		if(blogGroupMapper.selectByName(record.getName())!=null)
			return -1;
		return blogGroupMapper.insert(record);
	}
	//查询博客组
	@Override
	public BlogGroup selectGroupByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return blogGroupMapper.selectByPrimaryKey(id);
	}
	
	//更新所有组
	@Override
	public int updateGroupByPrimaryKey(BlogGroup record) {
		if(blogGroupMapper.selectByPrimaryKey(record.getId())==null)
			return -1;
		return blogGroupMapper.updateByPrimaryKey(record);
	}
	
	/**
	 * 查询用户的分组以及用户的分组中的博客
	 * @param userId
	 * @return
	 */
	@Override
	public List<BlogGroup> selectByUserId(int userId) {
		// TODO Auto-generated method stub
		return blogGroupMapper.selectByUserId(userId);
	}
	@Override
	public List<BlogGroup> selectByUserIdJustList(int userId) {
		// TODO Auto-generated method stub
		return blogGroupMapper.selectByUserIdJustList(userId);
	}
}
