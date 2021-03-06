package com.isco.Blog.Mapper;

import com.isco.Blog.POJO.Follow;
import com.isco.Blog.POJO.User;

import java.util.List;

/**
 * @author sazhijie
 * create time 2018/9/11 15:38
 * 用户关注表对应的DAO
 *
 */
public interface FollowMapper {
    int deleteByPrimaryKey(Integer id);

    
    

    Follow selectByPrimaryKey(Integer id);

    List<Follow> selectAll();

    int updateByPrimaryKey(Follow record);
    
    List<Follow> selectByUserId(int id);
    
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