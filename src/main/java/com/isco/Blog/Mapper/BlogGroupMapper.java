package com.isco.Blog.Mapper;

import com.isco.Blog.POJO.BlogGroup;
import java.util.List;

public interface BlogGroupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BlogGroup record);

    BlogGroup selectByPrimaryKey(Integer id);

    List<BlogGroup> selectAll();

    int updateByPrimaryKey(BlogGroup record);
}