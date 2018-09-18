package com.isco.Blog.POJO;

import java.util.List;

import com.isco.Blog.ResultEntity.BlogUserEntity;

public class BlogGroup {
    public List<BlogUserEntity> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<BlogUserEntity> blogs) {
		this.blogs = blogs;
	}

	private Integer id;

    private String name;

    private Integer userId;

    private Integer blogId;
    
    private List<BlogUserEntity> blogs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }
}