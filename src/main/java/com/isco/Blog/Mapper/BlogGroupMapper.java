package com.isco.Blog.Mapper;

import com.isco.Blog.POJO.BlogGroup;
import java.util.List;

/**
 * @author sazhijie
 * 创建时间 2018/9/19
 * 博客分组Mapper
 */
public interface BlogGroupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BlogGroup record);

    BlogGroup selectByPrimaryKey(Integer id);

    List<BlogGroup> selectAll();

    int updateByPrimaryKey(BlogGroup record);
    
    BlogGroup selectByName(String name);
    
    /**
     * 查看博客类别分组列表以及博客分组对应博客列表
     * @param userId
     * @return
     */
    List<BlogGroup> selectByUserId(int userId);
    
    /**
     * 查看博客分组，不包含博客
     * @param userId
     * @return
     */
    List<BlogGroup> selectByUserIdJustList(int userId);
}