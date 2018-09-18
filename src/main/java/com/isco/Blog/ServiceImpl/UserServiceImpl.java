package com.isco.Blog.ServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.isco.Blog.Mapper.BlogMapper;
import com.isco.Blog.Mapper.UserMapper;
import com.isco.Blog.POJO.User;

import com.isco.Blog.Service.IUserService;


/**
 * @author sazhijie
 * time 2018/9/7 15:45
 * Service层，处理用户的一系列业务
 * 开启事物，使用可重复读以及REQUIRES_NEW的传播行为
 *
 */
@EnableTransactionManagement
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW,isolation=Isolation.REPEATABLE_READ)
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private BlogMapper blogMapper;

	//根据主键删除
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.deleteByPrimaryKey(id);
	}
	
	//插入用户
	//@CachePut(value="user",key = "#user.getNumber()+'_'+#user.getPwd()")
	public int insert(User user) {
		// TODO Auto-generated method stub
		return userMapper.insert(user);
	}

	//根据主键查找用户
	public User selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(id);
	}

	//列出所有用户
	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return userMapper.selectAll();
	}

	//根据主键更新用户
	public int updateByPrimaryKey(User record) {
		// TODO Auto-generated method stub
		return userMapper.updateByPrimaryKey(record);
	}

	/*
	 * 使用Spring的缓存来实现Redis，当调用此方法时
	 * 先查询Redis中是否含有该对象
	 * 若有，则从Redis中查询
	 * 若无，则从Mysql中查询
	 * */
	//@Cacheable(value = "user" ,key= "#user.getNumber()+'_'+#user.getPwd()")
	@Override
	public User selectByNumberAndPwd(User user) {
		// TODO Auto-generated method stub
		return userMapper.selectByNumberAndPwd(user);
	}

	//根据电话号码查询用户
	@Override
	public User selectByNumber(String number){
		// TODO Auto-generated method stub
		return userMapper.selectByNumber(number);
	}

	//根据qqid查找用户
	@Override
	public User selectByQQId(String qqId) {
		// TODO Auto-generated method stub
		return userMapper.selectByQQId(qqId);
	}

	//根据微博id查找用户
	@Override
	public User selectByWBId(String wbId) {
		// TODO Auto-generated method stub
		return userMapper.selectByWBId(wbId);
	}

	//根据电话号码更新用户
	@Override
	public int updateByNumber(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateByNumber(user);
	}

	/* 查询用户关注
	 * @see com.isco.Blog.Service.IUserService#selectUserByFollow(int, int, int)
	 */
	@Override
	public Map<String,Object> selectUserByFollow(int userId, int param,int page) {
		Map<String, Object> map = new HashMap<>();
		int count = userMapper.selectUserByFollowCount(userId);
		int i = CaculateParam(param, page, count);
		if(i<0) {
			map.put("result", false);
			return map;
		}
		map.put("result", true);
		map.put("user", userMapper.selectUserByFollow(userId, i, page));
		map.put("page", (int)Math.ceil((double)count/page));
		return map;
	}
	
	/**
	 * 校验输入页码与每一页的个数
	 * 格式是否正确
	 * @param param
	 * @param page
	 * @param count
	 * @return
	 */
	public int CaculateParam(int param,int page,int count) {
		System.out.println("param="+param+",page="+page+",count="+count);
		if(param<1 || page<1) {
			return -2;
		}
		param--;
		param *= page;
		if(param>count-1)
			return -1;
		return param;
	}

	/* 根据用户id获取用户信息
	 * @see com.isco.Blog.Service.IUserService#getUserInfo(int)
	 */
	@Override
	public Map<String, Object> getUserInfo(int id) {
		Map<String,Object> map = new HashMap<>();
		map.put("user",  userMapper.selectByPrimaryKey(id));
		map.put("followNum", userMapper.selectUserByFollowCount(id));
		map.put("wasFollowedNum", userMapper.selectUserByWasFollowedCount(id));
		map.put("blogNum", blogMapper.selectByUserIdCount(id));
		return map;
	}

}
