package com.isco.Blog.Controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.isco.Blog.POJO.User;
import com.isco.Blog.Service.IUserService;
import com.isco.Blog.util.SengMessage;

/**
 * @author sazhijie
 * time 2018/9/6
 * 处理User的操作逻辑
 * 登录注册..
 *
 */
@RestController
public class UserController {
	
	@Autowired
    IUserService userServise;
	
	@RequestMapping(path="/getUserInfo",method=RequestMethod.GET)
	public Map<String,Object> getUserInfo(Integer id){
		if(id==null)
			return null;
		return userServise.getUserInfo(id);
	}
	
	//电话号码和密码登录
	@RequestMapping(path="/Login",method=RequestMethod.POST)
	public Map<String, Object> login(@RequestBody User user) {
		boolean b = false;
		Map<String, Object> map = new HashMap<>();
		User u = userServise.selectByNumberAndPwd(user);
		if(u!=null) { //有结果
			b=true;
		}
		map.put("result", b);
		map.put("user", u);
		return map;
	}
	
	//电话号码登录，配合短信功能使用
	@RequestMapping(path="/CaptchaLogin",method=RequestMethod.GET)
	public Map<String,Object> captchaLogin(@RequestParam String number) {
		boolean b=false;
		//发送短信
		Map<String,Object> map = new HashMap<>();
		User u = userServise.selectByNumber(number);
		if(u!=null) b=true;
		map.put("result", b);
		map.put("user", u);
		return map;
		
	}
	
	//发送短信
	@RequestMapping(path="/sendMessage",method=RequestMethod.GET)
	public Map<String,Object> sendMsg(@RequestParam String number) {
		Map<String, Object> map = new HashMap<>();
		boolean b=false;
		String s =getRandom();
		SengMessage send = new SengMessage(number, s);
		try {
			if(send.Send()) {
				b=true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("result", b);
		map.put("msg", s);
		return map;
	}
	
	//随机生成验证码
	private String getRandom(){//随机生成验证码
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <4; i++){
            sb.append( random.nextInt(10));
        }
        return sb.toString();
    }
	
	//qq登录
	@RequestMapping(path="/QQLogin",method=RequestMethod.GET)
	public Map<String,Object> qqLogin(@RequestParam String qqid){
		boolean b = false;
		Map<String, Object> map = new HashMap<>();
		User user = userServise.selectByQQId(qqid);
		if(user!=null) b=true;
		else {
			User u = new User();
			u.setQqId(qqid);
			if(userServise.insert(user)==1) b=true;
		}
		map.put("result", b);
		map.put("user", user);
		return map;
	}
	
	//微博登录
	@RequestMapping(path="/WBLogin",method=RequestMethod.GET)
	public Map<String,Object> wbLogin(@RequestParam String wbid){
		boolean b = false;
		Map<String, Object> map = new HashMap<>();
		User user = userServise.selectByQQId(wbid);
		if(user!=null) b=true;
		else {
			User u = new User();
			u.setWbId(wbid);
			if(userServise.insert(u)==1) b=true;
		}
		map.put("result", b);
		map.put("user", user);
		return map;
	}
	
	//更新用户信息
	@RequestMapping(path="/ChangeInfo",method=RequestMethod.POST)
	public int update(@RequestBody User u) {
		return userServise.updateByPrimaryKey(u);
	}
	
	//更改头像
	@RequestMapping(path="/ChangeImg",method=RequestMethod.POST)
	public Map<String, Object> changeImg(@RequestParam("file") MultipartFile file,
			@RequestParam("id") int id) {
		Map<String,Object> map = new HashMap<>();
		if(file==null) {
			map.put("result", -1);
			return map;
		}
		String name = file.getOriginalFilename();
		String b = name.substring(name.lastIndexOf(".") + 1);
		String path = "/var/www/html/img/"+id+"."+b;
		System.out.println(path);
		try {
			FileUtils.writeByteArrayToFile(new File(path), file.getBytes());
		} catch (IOException e) {
			map.put("result", -2);
			return map;
		}
		
		User user = new User();
		user.setId(id);
		user.setImg("http://120.79.184.27:81/img/"+id+"."+b);
		int i = userServise.updateByPrimaryKey(user);
		map.put("result", i);
		map.put("path", "http://120.79.184.27:81/img/"+id+"."+b);
		return map;
	}
	
	//注册
	@RequestMapping(path="/Register",method=RequestMethod.PUT)
	public int register(@RequestBody User user) {
		if(userServise.selectByNumber(user.getNumber())!=null){
			return 2;
		}
		return userServise.insert(user);
	}
	
	//删除用户
	@RequestMapping(path="/DeleteUser",method=RequestMethod.DELETE)
	public int delete(@RequestParam int id) {
		if(userServise.selectByPrimaryKey(id)==null){
			return -1;
		}
		return userServise.deleteByPrimaryKey(id);
	}

	
	/**
	 * 获取关注列表
	 * @param userId 用户的id
	 * @param param 分页参数
	 * @return list
	 * 返回用户列表
	 */
	@RequestMapping(path="/getFollow",method=RequestMethod.GET)
	public Map<String,Object> getFollow(Integer userId,Integer param,Integer page){
		if(userId==null||param==null||page==null) {
			Map<String, Object> map = new HashMap<>();
			map.put("result", false);
			return map;
		}
		return userServise.selectUserByFollow(userId, param,page);
	}

}
