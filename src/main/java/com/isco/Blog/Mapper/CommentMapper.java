package com.isco.Blog.Mapper;

import com.isco.Blog.POJO.Comment;
import com.isco.Blog.ResultEntity.CommentUserEntity;

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
    List<CommentUserEntity> selectAll(int start);
    //查询所有单个用户评论
    List<CommentUserEntity> selectAllByUserID(@Param("userID")int userID,@Param("start")int start);
    //查询所有单个博客评论
    List<CommentUserEntity> selectAllByBlogID(@Param("blogID")int blogID,@Param("start")int start);

    //查询评论下所有回复
    List<CommentUserEntity> selectAllByParentID(@Param("parentID")int parentID,@Param("start")int start);
    //更新评论
    int updateByPrimaryKey(Comment record);
}