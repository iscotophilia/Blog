package com.isco.Blog.Mapper;

import com.isco.Blog.POJO.ReportComment;
import java.util.List;

public interface ReportCommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReportComment record);

    ReportComment selectByPrimaryKey(Integer id);

    List<ReportComment> selectAll();

    int updateByPrimaryKey(ReportComment record);
}