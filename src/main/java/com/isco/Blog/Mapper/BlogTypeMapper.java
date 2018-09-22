package com.isco.Blog.Mapper;

import com.isco.Blog.POJO.BlogType;
import java.util.List;

/**
 * @author sazhijie
 * 创建时间 2018/9/19 17:25
 * 博客类别Mapper
 */
public interface BlogTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BlogType record);

    BlogType selectByPrimaryKey(Integer id);

    List<BlogType> selectAll();

    int updateByPrimaryKey(BlogType record);
    
    String selectName(int id);
    
    /**
     * 根据博客名称查看博客类别
     * @param name
     * @return
     */
    BlogType selectByName(String name);
    
}