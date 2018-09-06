package com.isco.Blog.Mapper;

import com.isco.Blog.POJO.User;
import java.util.List;

/**
 * @author sazhijie
 * time 2018/9/6 11:36
 * Dao层
 * 
 *
 */
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
    
    User selectByNumberAndPwd(User user);
    
    User selectByNumber(String number);
}