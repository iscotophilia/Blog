package com.isco.Blog.Mapper;

import com.isco.Blog.POJO.Save;
import java.util.List;

/**
 * @author sazhijie
 * create time 2018/9/13 14:39
 * 用户收藏
 */
public interface SaveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Save record);

    Save selectByPrimaryKey(Integer id);

    List<Save> selectAll();

    int updateByPrimaryKey(Save record);
    
    /**
     * 查询用户是否已收藏
     * @param save
     * @return
     */
    Save selectByUserIdAndBlogId(Save save);
}