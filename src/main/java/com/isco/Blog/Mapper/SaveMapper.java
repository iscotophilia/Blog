package com.isco.Blog.Mapper;

import com.isco.Blog.POJO.Save;
import java.util.List;

public interface SaveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Save record);

    Save selectByPrimaryKey(Integer id);

    List<Save> selectAll();

    int updateByPrimaryKey(Save record);
}