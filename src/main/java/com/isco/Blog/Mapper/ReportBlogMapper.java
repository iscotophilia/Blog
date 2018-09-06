package com.isco.Blog.Mapper;

import com.isco.Blog.POJO.ReportBlog;
import java.util.List;

public interface ReportBlogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReportBlog record);

    ReportBlog selectByPrimaryKey(Integer id);

    List<ReportBlog> selectAll();

    int updateByPrimaryKey(ReportBlog record);
}