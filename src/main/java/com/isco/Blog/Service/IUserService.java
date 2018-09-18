package com.isco.Blog.Service;

import java.util.List;
import java.util.Map;

import com.isco.Blog.POJO.User;

/**
 * @author sazhijie
 * create date 2018/9/11 14:59
 * 用户逻辑的服务
 *
 */
public interface IUserService {
	int deleteByPrimaryKey(Integer id);

	int insert(User record);

	User selectByPrimaryKey(Integer id);

	List<User> selectAll();

	int updateByPrimaryKey(User record);

	User selectByNumberAndPwd(User user);

	User selectByNumber(String number);

	// qq登录验证
	User selectByQQId(String qqId);

	// 微博登录验证
	User selectByWBId(String wbId);

	int updateByNumber(User user);
	
	/**
	 * 查询用户关注的人
	 * @param userId
	 * @param param
	 * @return list
	 * 返回用户关注列表
	 */
	Map<String,Object> selectUserByFollow(int userId,int param,int page);
	
	Map<String,Object> getUserInfo(int id);
}
