package com.isco.Blog.Mapper;

import com.isco.Blog.POJO.Love;
import java.util.List;

/**
 * @author sazhijie
 * create time 2018/9/13 14:40
 * 用户点赞实现
 */
public interface LoveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Love record);

    Love selectByPrimaryKey(Integer id);

    List<Love> selectAll();

    int updateByPrimaryKey(Love record);
    
    /**
     * 查询用户是否已经点过赞
     * @param love
     * @return
     */
    Love selectByUserIdAndBlogId(Love love);
    
    /**
     * 取消赞
     * @param love
     * @return
     */
    int deleteByUserIdAndBlogId(Love love);
}