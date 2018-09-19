package com.isco.Blog.Service;

/**
 * @author sazhijie
 * 创建时间 2018/9/19 9:16
 * 收藏功能的Service
 *
 */
public interface SaveService {
	
	 /**
     * 收藏
     * @param userId
     * @param blogId
     * @return
     */
    int updateSave(int userId,int blogId);
    
    
    /**
     * 取消收藏
     * @param userId
     * @param blogId
     * @return
     */
    int cancelSave(int userId,int blogId);

}
