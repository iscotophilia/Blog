package com.isco.Blog.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isco.Blog.Mapper.CommentMapper;
import com.isco.Blog.POJO.Comment;
import com.isco.Blog.Service.CommentService;
@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentMapper commentMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return commentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Comment record) {
		// TODO Auto-generated method stub
		return commentMapper.insert(record);
	}

	@Override
	public Comment selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return commentMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Comment> selectAll() {
		// TODO Auto-generated method stub
		return commentMapper.selectAll();
	}

	@Override
	public List<Comment> selectAllByUserID(int userID) {
		// TODO Auto-generated method stub
		return commentMapper.selectAllByUserID(userID);
	}

	@Override
	public List<Comment> selectAllByBlogID(int blogID, int start,int size) {
		// TODO Auto-generated method stub
		return commentMapper.selectAllByBlogID(blogID, start, size);
	}

	@Override
	public int updateByPrimaryKey(Comment record) {
		// TODO Auto-generated method stub
		return commentMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Comment> selectAllByLove(int blogID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int append(Comment record) {
		// TODO Auto-generated method stub
		return commentMapper.append(record);
	}

	@Override
	public List<Comment> selectAllByParentID(int parentID, int start, int size) {
		// TODO Auto-generated method stub
		return commentMapper.selectAllByParentID(parentID, start, size);
	}

}
