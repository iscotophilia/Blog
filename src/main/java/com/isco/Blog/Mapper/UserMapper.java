package com.isco.Blog.Mapper;

import com.isco.Blog.POJO.User;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * @author sazhijie
 *  time 2018/9/6 11:36 Dao层
 *
 */
public interface UserMapper {
	// 通过主键删除
	int deleteByPrimaryKey(Integer id);

	// 插入用户
	int insert(User record);

	// 主键查询用户
	User selectByPrimaryKey(Integer id);

	// 查询所有用户
	List<User> selectAll();

	// 更具主键更新
	int updateByPrimaryKey(User record);

	// 根据手机号和密码查询
	User selectByNumberAndPwd(User user);

	// 根据手机号查询
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
	List<User> selectUserByFollow(@Param("userId")int userId,@Param("param")int param,@Param("page")int page);
	int selectUserByFollowCount(int userId);
	//查看有多少人关注了该用户
	int selectUserByWasFollowedCount(int followId);
	
	List<Object> selectTopUser();
}