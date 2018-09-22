package com.isco.Blog.Mapper;

import com.isco.Blog.POJO.Blog;
import com.isco.Blog.ResultEntity.BlogUserEntity;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @author sazhijie
 * time 2018/9/11 10:10
 * 博客Dao
 *
 */
public interface BlogMapper {
	
	/**
	 * @author sazhijie
	 * 更新:2018/9/11 14:10
	 *
	 */
	
    /**
     * 根据主键删除博客
     * @param id
     * @return int
     * 返回状态值，返回1为成功，其他失败
     */
    Integer deleteByPrimaryKey(Integer id);

    
    /**
     * 新增博客
     * @param record
     * @return int
     * 返回状态值
     * 返回1为成功，其他失败
     */
    Integer insert(Blog record);
    
    /**
     * 根据主键查询
     * @param id
     * @return Blog实体
     * 查询后返回Blog对象
     */
    Blog selectByPrimaryKey(Integer id);

    
    /**
     * 查询所有博客
     * @return 博客列表
     */
    List<Blog> selectAll();

    /**
     * 更新博客
     * @param record
     * @return int
     * 返回状态值，1为成功，其他失败
     */
    Integer updateByPrimaryKey(Blog record);
    
    
    /**
     * 查询最新博客
     * @param param
     * 参数为分页参数
     * @return
     * 返回博客列表
     */
    List<BlogUserEntity> selectByTime(@Param("param")int param,@Param("page") int page);
    
    /**
     * 查询被点赞最多的博客
     * @param param
     * @return
     */
    List<BlogUserEntity> selectByLove(@Param("param")int param,@Param("page") int page);
    
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
    List<BlogUserEntity> selectByFollowId(@Param("userId")int userId,@Param("param")int param,@Param("page") int page);
    
    
    /**查询总条数
     * @return
     */
    Integer selectCount();
    Integer selectByFollowIdCount(int userId);
    Integer selectByUserIdCount(int userId);
    
    /**
     * 查询某个用户的博客
     * @param userId
     * @param param
     * @param page
     * @return
     * 返回博客列表
     * 根据时间排序
     */
    List<BlogUserEntity> selectByUserId(@Param("userId")int userId,@Param("param") int param,@Param("page")int page);
    
    List<BlogUserEntity> selectByUserIdAndLove(@Param("userId")int userId,@Param("param") int param,@Param("page")int page);
    Integer selectByUserIdAndLoveCount(int userId);
    
    List<BlogUserEntity> selectByUserIdAndComment(@Param("userId")int userId,@Param("param") int param,@Param("page")int page);
    Integer selectByUserIdAndCommentCount(int userId);
    
    List<BlogUserEntity> selectByUserIdAndSave(@Param("userId")int userId,@Param("param") int param,@Param("page")int page);
    Integer selectByUserIdAndSaveCount(int userId);
    
    
    /**
     * 根据博客类别查询博客
     * @param blogTypeId
     * @param param
     * @param page
     * @return
     */
    List<BlogUserEntity> selectByTimeWithType(@Param("blogTypeId")int blogTypeId,@Param("param")int param,@Param("page")int page);
    Integer selectByTimeWithTypeCount(int blogTypeId);
    
    List<BlogUserEntity> selectByGroup(int id);
    
    /**
     * 减少点赞数和评论数
     * @param blog
     * @return
     */
    Integer deleteLoveNumOrCommentNum(Blog blog);
    
    /**
     * 查看用户的被点赞数
     * @param userId
     * @return
     */
    Integer selectLoveNumByUserId(int userId);
    
    List<BlogUserEntity> selectByLike(@Param("title")String title,@Param("param") int param,@Param("page")int page);
    Integer selectByLikeCount(String title);
    
}