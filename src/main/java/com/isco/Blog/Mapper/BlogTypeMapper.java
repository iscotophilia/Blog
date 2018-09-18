package com.isco.Blog.Mapper;

import com.isco.Blog.POJO.BlogType;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BlogTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BlogType record);

    BlogType selectByPrimaryKey(Integer id);

    List<BlogType> selectAll();

    int updateByPrimaryKey(BlogType record);
    
    String selectName(int id);
    
}