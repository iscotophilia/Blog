package com.isco.Blog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.isco.Blog.POJO.Follow;
import com.isco.Blog.Service.FollowService;

/**
 * @author sazhijie
 * create time 2018/9/11 15:48
 * 用户关注处理Controller
 *
 */

@RestController
public class FollowController {
	
	/**
	 * @author sazhijie
	 * 最后修改时间 2018/9/11 15:55
	 */
	
	@Autowired
	private FollowService followService;
	
	
	/**
	 * 添加关注
	 * 主要输入为用户id和被关注的用户id
	 * @param follow
	 * @return
	 * 返回状态值，为1表示关注成功,其他表示失败
	 */
	@RequestMapping(path="/addFollow",method=RequestMethod.POST)
	public int addFollow(@RequestBody Follow follow) {
		if(followService.selectByUserIdAndFollowId(follow)!=null) {
			return 1;
		}
		return followService.insert(follow);
	}
	
	
	/**
	 * 取消关注
	 * 主要输入为用户id以及被关注用户的id
	 * @param follow
	 * @return
	 * 返回状态值，为1表示取消关注成功，其他表示失败
	 */
	@RequestMapping(path="/cancelFollow",method=RequestMethod.POST)
	public int cancelFollow(@RequestBody Follow follow) {
		if(followService.selectByUserIdAndFollowId(follow)==null) {
			return 1;
		}
		return followService.deleteByUserIdAndFollowId(follow);
	}

}
