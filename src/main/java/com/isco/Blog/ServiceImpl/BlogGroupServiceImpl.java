package com.isco.Blog.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isco.Blog.Mapper.BlogGroupMapper;
import com.isco.Blog.POJO.BlogGroup;
import com.isco.Blog.Service.BlogGroupService;
@Service
public class BlogGroupServiceImpl implements BlogGroupService {
	
	@Autowired
	BlogGroupMapper BlogGroupMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(BlogGroup record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BlogGroup selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BlogGroup> selectAll() {
		return BlogGroupMapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(BlogGroup record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
