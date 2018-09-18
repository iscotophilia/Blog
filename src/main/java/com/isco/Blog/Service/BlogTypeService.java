package com.isco.Blog.Service;

import java.util.List;

import com.isco.Blog.POJO.BlogType;

public interface BlogTypeService {
	//以下为博客类型的操作
	//删除博客类型
    int deleteTypeByPrimaryKey(Integer id);
    //插入博客类型
    int insertType(BlogType record);
    //查询博客类型
    BlogType selectTypeByPrimaryKey(Integer id);
    //列出所有博客类型
    List<BlogType> selectAllType();
    //更新博客类型
    int updateTypeByPrimaryKey(BlogType record);

}
