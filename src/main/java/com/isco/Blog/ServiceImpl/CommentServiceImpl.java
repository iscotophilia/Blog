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
import com.isco.Blog.Service.CommentService;
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW,isolation=Isolation.REPEATABLE_READ)
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentMapper commentMapper;
	
	@Autowired
	private BlogMapper blogMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return commentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Comment record) {
		Blog b= new Blog();
		b.setId(record.getBlogId());
		b.setCommentNum(1);
		blogMapper.updateByPrimaryKey(b);
		return commentMapper.insert(record);
	}

	@Override
	public Comment selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return commentMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Object> selectAll(int start) {
		// TODO Auto-generated method stub
		return commentMapper.selectAll(start);
	}

	@Override
	public List<Object> selectAllByUserID(int userID,int start) {
		// TODO Auto-generated method stub
		return commentMapper.selectAllByUserID(userID,start);
	}

	/* 查看博客的第一层评论
	 * @see com.isco.Blog.Service.CommentService#selectAllByBlogID(int, int)
	 */
	@Override
	public List<Object> selectAllByBlogID(int blogID, int start) {
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

	@Override
	public List<Object> selectAllByParentID(int parentID, int start) {
		// TODO Auto-generated method stub
		return commentMapper.selectAllByParentID(parentID, start);
	}

}
