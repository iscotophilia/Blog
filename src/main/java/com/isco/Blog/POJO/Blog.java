package com.isco.Blog.POJO;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author sazhijie
 * 创建时间 2018/9/24 13:05
 * 博客实体
 */
public class Blog {
	public Integer getBlogGroupId() {
		return blogGroupId;
	}

	public void setBlogGroupId(Integer blogGroupId) {
		this.blogGroupId = blogGroupId;
	}

	private Integer id;

	private String title;

	private Integer userId;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date time;

	private Integer commentNum;

	private Integer loveNum;
	
	private String pic;

	private Integer blogTypeId;
	
	private Integer blogGroupId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Integer getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(Integer commentNum) {
		this.commentNum = commentNum;
	}

	public Integer getLoveNum() {
		return loveNum;
	}

	public void setLoveNum(Integer loveNum) {
		this.loveNum = loveNum;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic == null ? null : pic.trim();
	}

	public Integer getBlogTypeId() {
		return blogTypeId;
	}

	public void setBlogTypeId(Integer blogTypeId) {
		this.blogTypeId = blogTypeId;
	}
}