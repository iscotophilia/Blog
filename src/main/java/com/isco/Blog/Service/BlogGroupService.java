package com.isco.Blog.Service;

import java.util.List;

import com.isco.Blog.POJO.BlogGroup;

public interface BlogGroupService {
	
	int deleteByPrimaryKey(Integer id);

    int insert(BlogGroup record);

    BlogGroup selectByPrimaryKey(Integer id);

    List<BlogGroup> selectAll();

    int updateByPrimaryKey(BlogGroup record);

}
