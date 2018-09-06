package com.isco.Blog.Mapper;

import com.isco.Blog.POJO.BlogText;
import java.util.List;

public interface BlogTextMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BlogText record);

    BlogText selectByPrimaryKey(Integer id);

    List<BlogText> selectAll();

    int updateByPrimaryKey(BlogText record);
}