package com.isco.Blog.Service;

import java.util.List;

import com.isco.Blog.POJO.User;

public interface IUserService {
	int deleteByPrimaryKey(Integer id);

    User insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    User selectByNumberAndPwd(User user);
    
    User selectByNumber(String number);
}
