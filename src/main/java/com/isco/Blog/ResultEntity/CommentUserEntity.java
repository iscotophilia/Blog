package com.isco.Blog.ResultEntity;

import com.isco.Blog.POJO.Comment;

public class CommentUserEntity extends Comment {

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	private String name;

	private String img;

	private String sign;

}
