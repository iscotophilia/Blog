package com.isco.Blog.POJO;

/**
 * @author sazhijie
 * time 2018/9/6 17:07
 * 被举报博客实体
 *
 */
public class ReportBlog {

	private Integer id;

    private Integer blogId;
    
    private Integer num;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }
    
    public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
}