package com.isco.Blog.Service;

import java.util.List;

import com.isco.Blog.POJO.Follow;
import com.isco.Blog.POJO.User;

public interface FollowService {
	
	List<Follow> selectByUserId(int userId);
	
	int deleteByUserId(int id);
	
	/**
     * 添加关注，根据用户id和followId来添加
     * @param record
     * @return int
     * 返回状态值
     */
    int insert(Follow record);
    
    /**
     * 根据用户id和followid来取消关注
     * @param follow
     * @return int
     * 返回状态值，返回1成功，其余失败
     */
    int deleteByUserIdAndFollowId(Follow follow);
    
    /**
     * 根据用户id和followid来查询是否关注
     * @param follow
     * @return Follow
     * 返回关注信息
     */
    Follow selectByUserIdAndFollowId(Follow follow);

}
