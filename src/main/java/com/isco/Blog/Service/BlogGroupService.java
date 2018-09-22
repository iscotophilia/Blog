package com.isco.Blog.Service;

import java.util.List;

import com.isco.Blog.POJO.BlogGroup;
/**
 * 
 * @author 张硕
 *
 */
public interface BlogGroupService {
	
	//以下为博客组的操作
    //删除博客组
    int deleteGroupByPrimaryKey(Integer id);
    //插入博客组
    int insertGroup(BlogGroup record);
    //查询博客组
    BlogGroup selectGroupByPrimaryKey(Integer id);
    //更新博客组
    int updateGroupByPrimaryKey(BlogGroup record);
	
    /**
     * 列出分组和博客
     * @param userId
     * @return
     */
    List<BlogGroup> selectByUserId(int userId);
    
    /**
     * 列出分组
     * @param userId
     * @return
     */
    List<BlogGroup> selectByUserIdJustList(int userId);
}
