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

	/* 查询用户关注
	 * @see com.isco.Blog.Service.FollowService#selectByUserId(int)
	 */
	@Override
	public List<Follow> selectByUserId(int userId) {
		// TODO Auto-generated method stub
		return followMapper.selectByUserId(userId);
	}

	/* 删除关注
	 * @see com.isco.Blog.Service.FollowService#deleteByUserId(int)
	 */
	@Override
	public int deleteByUserId(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* 添加关注
	 * @see com.isco.Blog.Service.FollowService#insert(com.isco.Blog.POJO.Follow)
	 */
	@Override
	public int insert(Follow record) {
		// TODO Auto-generated method stub
		return followMapper.insert(record);
	}

	/* 取消关注
	 * @see com.isco.Blog.Service.FollowService#deleteByUserIdAndFollowId(com.isco.Blog.POJO.Follow)
	 */
	@Override
	public int deleteByUserIdAndFollowId(Follow follow) {
		// TODO Auto-generated method stub
		return followMapper.deleteByUserIdAndFollowId(follow);
	}

	/* 查询是否关注
	 * @see com.isco.Blog.Service.FollowService#selectByUserIdAndFollowId(com.isco.Blog.POJO.Follow)
	 */
	@Override
	public Follow selectByUserIdAndFollowId(Follow follow) {
		// TODO Auto-generated method stub
		return followMapper.selectByUserIdAndFollowId(follow);
	}

}
