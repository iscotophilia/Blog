package com.isco.Blog.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.isco.Blog.Mapper.BlogMapper;
import com.isco.Blog.Mapper.CommentMapper;
import com.isco.Blog.POJO.Blog;
import com.isco.Blog.POJO.Comment;
import com.isco.Blog.ResultEntity.CommentUserEntity;
import com.isco.Blog.Service.CommentService;

/**
 * @author sazhijie
 * 创建时间 2018/9/24
 * 评论Service实现
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW,isolation=Isolation.REPEATABLE_READ)
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentMapper commentMapper;
	
	@Autowired
	private BlogMapper blogMapper;
	
	/* 删除评论
	 * @see com.isco.Blog.Service.CommentService#deleteByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return commentMapper.deleteByPrimaryKey(id);
	}

	/* 新增评论
	 * @see com.isco.Blog.Service.CommentService#insert(com.isco.Blog.POJO.Comment)
	 */
	@Override
	public int insert(Comment record) {
		Blog b= new Blog();
		b.setId(record.getBlogId());
		b.setCommentNum(1);
		blogMapper.updateByPrimaryKey(b);
		return commentMapper.insert(record);
	}

	/* 查找评论
	 * @see com.isco.Blog.Service.CommentService#selectByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public Comment selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return commentMapper.selectByPrimaryKey(id);
	}

	/* 查看所有评论
	 * @see com.isco.Blog.Service.CommentService#selectAll(int)
	 */
	@Override
	public List<CommentUserEntity> selectAll(int start) {
		return commentMapper.selectAll(start);
	}

	/* 查看用户的所有评论
	 * @see com.isco.Blog.Service.CommentService#selectAllByUserID(int, int)
	 */
	@Override
	public List<CommentUserEntity> selectAllByUserID(int userID,int start) {
		// TODO Auto-generated method stub
		return commentMapper.selectAllByUserID(userID,start);
	}

	/* 查看博客的第一层评论
	 * @see com.isco.Blog.Service.CommentService#selectAllByBlogID(int, int)
	 */
	@Override
	public List<CommentUserEntity> selectAllByBlogID(int blogID, int start) {
		// TODO Auto-generated method stub
		return commentMapper.selectAllByBlogID(blogID, start);
	}

	/* 更新评论
	 * @see com.isco.Blog.Service.CommentService#updateByPrimaryKey(com.isco.Blog.POJO.Comment)
	 */
	@Override
	public int updateByPrimaryKey(Comment record) {
		// TODO Auto-generated method stub
		return commentMapper.updateByPrimaryKey(record);
	}

	/* 查看第二层评论
	 * @see com.isco.Blog.Service.CommentService#selectAllByParentID(int, int)
	 */
	@Override
	public List<CommentUserEntity> selectAllByParentID(int parentID, int start) {
		// TODO Auto-generated method stub
		return commentMapper.selectAllByParentID(parentID, start);
	}

}
