package com.isco.Blog.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.isco.Blog.POJO.Blog;


/**
 * 
 * @author 张硕
 *
 */

public interface BlogService {
	

	//删除博客包括内容
    int deleteByPrimaryKey(int id);
    //查询博客仅包括项目
    Blog selectByPrimaryKey(int id);
    //列出所有博客项目
    List<Blog> selectAll();
    //列出单个用户博客项目
    List<Blog> selectOnes(int user_id);
    //更新博客项目不包括内容
    int updateByPrimaryKey(Blog record);
    
    /**
     * 查询最新博客
     * @param param
     * 参数为分页参数
     * @return
     * 返回博客列表
     */
    Map<String,Object> selectByTime(int param,int page);
    
    /**
     * 查询被点赞最多的博客
     * @param param
     * @return
     */
    Map<String,Object> selectByLove(int param,int page);
    
    /**
     * 查询用户关注的人的博客
     * @param userId 用户id
     * @param param 分页参数
     * @return 博客列表
     * 根据用户id查询其所关注的人
     * 再根据用户关注的人的id
     * 查询这些人的博客
     * 最后根据时间排序
     */
    Map<String,Object> selectByFollowId(int userId,int param,int page);
    
    
    /**
     * 用户添加博客
     * @param title
     * @param userId
     * @param type
     * @param group
     * @param text
     * @return
     */
    int insertBlog(String title,int userId,int type,int group,String text,String path,Date date);
    
    /**
     * 查询某个用户的博客
     * @param userId
     * @param param
     * @param page
     * @return
     * 返回博客列表
     * 根据时间排序
     */
    Map<String,Object> selectByUserId(int userId,int param,int page);
    
    
    /**
     * 点赞
     * @param userId
     * @param blogId
     * @return
     */
    int updateLove(int userId,int blogId);
    
    /**
     * 收藏
     * @param userId
     * @param blogId
     * @return
     */
    int updateSave(int userId,int blogId);
    
    /**
     * 获取被用户点赞的博客列表
     * @param userId
     * @param param
     * @param page
     * @return
     * 返回一个内嵌列表的map
     */
    Map<String,Object> selectByUserIdAndLove(int userId,int param,int page);
    
    /**
     * 获取被用户点赞的博客列表
     * @param userId
     * @param param
     * @param page
     * @return
     * 返回一个内嵌列表的map
     */
    Map<String,Object> selectByUserIdAndComment(int userId,int param,int page);
    
    /**
     * 获取被用户收藏的博客列表
     * @param userId
     * @param param
     * @param page
     * @return
     * 返回一个内嵌列表的map
     */
    Map<String,Object> selectByUserIdAndSave(int userId,int param,int page);
    
    /**
     * 获取不同类别的博客
     * @param blogTypeId
     * @param param
     * @param page
     * @return
     */
    Map<String,Object> selectByTimeWithType(int blogTypeId,int param,int page);
    
    Map<String,Object> selectBlogWhitText(int userId,int blogId);
}
