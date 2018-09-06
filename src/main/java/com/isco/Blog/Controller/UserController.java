package com.isco.Blog.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.httpclient.HttpException;
import org.apache.naming.factory.SendMailFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isco.Blog.POJO.User;
import com.isco.Blog.Service.IUserService;
import com.isco.Blog.util.SengMessage;

@RestController
public class UserController {
	
	@Autowired
    IUserService userServise;
	
	@RequestMapping("/Login")
	public Map<String, Object> login(@RequestBody User user) {
		boolean b = false;
		Map<String, Object> map = new HashMap<>();
		User u = userServise.selectByNumberAndPwd(user);
		
		if(u!=null) {
			b=true;
		}
		map.put("result", b);
		map.put("user", u);
		return map;
	}
	
	@RequestMapping("/CaptchaLogin")
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
	
	@RequestMapping("sendMessage")
	public Map<String,Object> sendMsg(String number) {
		System.out.println(number);
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
	
	private String getRandom(){//随机生成验证码
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <4; i++){
            sb.append( random.nextInt(10));
        }
        return sb.toString();
    }
	
	@RequestMapping("/Register")
	public int register(@RequestBody User user) {
		
		return 0;
	}


}
