package com.isco.Blog.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.isco.Blog.Mapper.UserMapper;
import com.isco.Blog.POJO.User;

import com.isco.Blog.Service.IUserService;


@EnableTransactionManagement
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW,isolation=Isolation.READ_COMMITTED)
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserMapper userMapper;

	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.deleteByPrimaryKey(id);
	}
	
	@CachePut(value="user",key = "#user.getNumber()+'_'+#user.getPwd()")
	public User insert(User user) {
		// TODO Auto-generated method stub
		System.out.println("使用mysql存储");
		userMapper.insert(user);
		return user;
	}

	public User selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(id);
	}

	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return userMapper.selectAll();
	}

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
	@Cacheable(value = "user" ,key= "#user.getNumber()+'_'+#user.getPwd()")
	@Override
	public User selectByNumberAndPwd(User user) {
		// TODO Auto-generated method stub
		System.out.println("使用mysql查询");
		return userMapper.selectByNumberAndPwd(user);
	}

	@Override
	public User selectByNumber(String number){
		// TODO Auto-generated method stub
		return userMapper.selectByNumber(number);
	}

}
