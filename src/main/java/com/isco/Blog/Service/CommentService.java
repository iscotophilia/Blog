package com.isco.Blog.Service;

import java.util.List;

import com.isco.Blog.POJO.Comment;
/**
 * 
 * @author 张硕
 *
 */
public interface CommentService {

	//删除评论
    int deleteByPrimaryKey(Integer id);
    //插入评论
    int insert(Comment record);
    //查询评论
    Comment selectByPrimaryKey(Integer id);
    //查询所有评论
    List<Object> selectAll(int start);
    //查询所有单个用户评论
    List<Object> selectAllByUserID(int userID,int start);
    //查询所有单个博客评论
    List<Object> selectAllByBlogID(int blogID,int start);
    //查询评论下所有回复
    List<Object> selectAllByParentID(int parentID,int start);
    //更新评论
    int updateByPrimaryKey(Comment record);
}
