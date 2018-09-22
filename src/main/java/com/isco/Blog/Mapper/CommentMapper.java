package com.isco.Blog.Mapper;

import com.isco.Blog.POJO.Comment;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * @author sazhijie
 * 创建时间 2018/9/20 16:34
 * 评论Mapper
 */
public interface CommentMapper {
	//删除评论
    int deleteByPrimaryKey(Integer id);
    //插入评论
    int insert(Comment record);
    //查询评论
    Comment selectByPrimaryKey(Integer id);
    //查询所有评论
    List<Object> selectAll(int start);
    //查询所有单个用户评论
    List<Object> selectAllByUserID(@Param("userID")int userID,@Param("start")int start);
    //查询所有单个博客评论
    List<Object> selectAllByBlogID(@Param("blogID")int blogID,@Param("start")int start);

    //查询评论下所有回复
    List<Object> selectAllByParentID(@Param("parentID")int parentID,@Param("start")int start);
    //更新评论
    int updateByPrimaryKey(Comment record);
}