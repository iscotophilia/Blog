package com.isco.Blog.Service;

public interface LoveService {
	
	/**
     * 点赞
     * @param userId
     * @param blogId
     * @return
     */
    int updateLove(int userId,int blogId);
    
    
    /**
     * 取消赞
     * @param userId
     * @param blogId
     * @return
     */
    int cancelLove(int userId,int blogId);

}
