package com.isco.Blog.Mapper;

import com.isco.Blog.POJO.Blog;
import java.util.List;

public interface BlogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Blog record);

    Blog selectByPrimaryKey(Integer id);

    List<Blog> selectAll();

    int updateByPrimaryKey(Blog record);
}