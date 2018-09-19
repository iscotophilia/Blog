package com.isco.Blog.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isco.Blog.Mapper.BlogTypeMapper;
import com.isco.Blog.POJO.BlogType;
import com.isco.Blog.Service.BlogTypeService;
@Service
public class BlogTypeServiceImpl implements BlogTypeService{
	
	@Autowired
	private BlogTypeMapper blogTypeMapper;
	//删除博客类型
	@Override
	public int deleteTypeByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return blogTypeMapper.deleteByPrimaryKey(id);
	}
	//插入博客类型
	@Override
	public int insertType(BlogType record) {
		if(blogTypeMapper.selectByName(record.getName())!=null)
			return -1;
		return blogTypeMapper.insert(record);
	}
	//查询博客类型
	@Override
	public BlogType selectTypeByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return blogTypeMapper.selectByPrimaryKey(id);
	}
	//查询所有博客类型
	@Override
	public List<BlogType> selectAllType() {
		// TODO Auto-generated method stub
		return blogTypeMapper.selectAll();
	}
	//更新博客类型
	@Override
	public int updateTypeByPrimaryKey(BlogType record) {
		if(blogTypeMapper.selectByPrimaryKey(record.getId())==null)
			return -1;
		return blogTypeMapper.updateByPrimaryKey(record);
	}
}
