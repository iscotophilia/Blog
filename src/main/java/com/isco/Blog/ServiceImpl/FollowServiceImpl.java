package com.isco.Blog.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.isco.Blog.Mapper.FollowMapper;
import com.isco.Blog.POJO.Follow;
import com.isco.Blog.Service.FollowService;


/**
 * @author sazhijie
 * create time 2018/9/11 16:01
 * 关注表的service层
 *
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW,isolation=Isolation.REPEATABLE_READ)
public class FollowServiceImpl implements FollowService {
	
	@Autowired
	private FollowMapper followMapper;

	@Override
	public List<Follow> selectByUserId(int userId) {
		// TODO Auto-generated method stub
		return followMapper.selectByUserId(userId);
	}

	@Override
	public int deleteByUserId(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Follow record) {
		// TODO Auto-generated method stub
		return followMapper.insert(record);
	}

	@Override
	public int deleteByUserIdAndFollowId(Follow follow) {
		// TODO Auto-generated method stub
		return followMapper.deleteByUserIdAndFollowId(follow);
	}

	@Override
	public Follow selectByUserIdAndFollowId(Follow follow) {
		// TODO Auto-generated method stub
		return followMapper.selectByUserIdAndFollowId(follow);
	}

}
