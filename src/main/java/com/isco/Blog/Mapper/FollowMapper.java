package com.isco.Blog.Mapper;

import com.isco.Blog.POJO.Follow;
import java.util.List;

public interface FollowMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Follow record);

    Follow selectByPrimaryKey(Integer id);

    List<Follow> selectAll();

    int updateByPrimaryKey(Follow record);
}