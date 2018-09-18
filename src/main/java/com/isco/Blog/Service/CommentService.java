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
    //回复评论
    int append(Comment record);
    //查询评论
    Comment selectByPrimaryKey(Integer id);
    //查询所有评论
    List<Comment> selectAll();
    //查询所有单个用户评论
    List<Comment> selectAllByUserID(int userID);
    //查询所有单个博客评论
    List<Comment> selectAllByBlogID(int blogID,int start,int size);
    //查询博客最高赞评论
    List<Comment> selectAllByLove(int blogID);
    //查询评论下所有回复
    List<Comment> selectAllByParentID(int parentID,int start,int size);
    //更新评论
    int updateByPrimaryKey(Comment record);
}
