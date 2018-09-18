package com.isco.Blog.POJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


/**
 * @author sazhijie
 * time 2018/9/11
 * 用户关注实体
 *
 */
@SuppressWarnings("deprecation")
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(value = {"handler"})
public class Follow {

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private Integer id;

    private Integer userId;

    private Integer followId;
    
    //关注的用户
    private User user;
    
    //Getter Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFollowId() {
        return followId;
    }

    public void setFollowId(Integer followId) {
        this.followId = followId;
    }
}