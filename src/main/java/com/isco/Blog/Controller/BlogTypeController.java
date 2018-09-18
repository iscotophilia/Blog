package com.isco.Blog.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isco.Blog.POJO.BlogType;
import com.isco.Blog.Service.BlogTypeService;

@RestController
public class BlogTypeController {

	@Autowired
    BlogTypeService blogTypeService;
	//以下是对于博客类型的操作
	//新建博客类型（管理员操作）
	@RequestMapping(path="/addBlogType",method=RequestMethod.POST)
	public Map<String, Object> addBlogType(@RequestBody BlogType bType) {
		boolean b = false;
		Map<String, Object> map = new HashMap<>();
		if(bType!=null&&bType.getId()!=null) {
			if(blogTypeService.insertType(bType)==1)
			{
				b=true;
			}
			map.put("result", b);
		}else {
			map.put("result", b);
		}
		return map;
	}
	//更改博客类型
	@RequestMapping(path="/updateBlogType",method=RequestMethod.POST)
	public Map<String, Object> updateBlogType(@RequestBody BlogType bType) {
		boolean b = false;
		Map<String, Object> map = new HashMap<>();
		if(bType!=null&&bType.getId()!=null) {
			if(blogTypeService.updateTypeByPrimaryKey(bType)==1)
			{
				b=true;
			}
			map.put("result", b);
		}else {
			map.put("result", b);
		}
		return map;
	}
	//删除博客类型
	@RequestMapping(path="/delBlogType",method=RequestMethod.DELETE)
	public Map<String, Object> delBlogType(@RequestBody Map<String,Object> params) {
		boolean b = false;
		Map<String, Object> map = new HashMap<>();
		if(params.get("typeid").toString()!=null) {
			if(blogTypeService.deleteTypeByPrimaryKey(Integer.valueOf(params.get("typeid").toString()))==1)
			{
				b=true;
			}
			map.put("result", b);
		}else {
			map.put("result", b);
		}
		return map;
	}
	//列出所有博客类型
	@RequestMapping(path="/listBlogType",method=RequestMethod.POST)
	public Map<String, Object> ListBlogType() {
		boolean b = false;
		Map<String, Object> map = new HashMap<>();
		List<BlogType> bTypes=blogTypeService.selectAllType();
		
		b=true;
		map.put("result", b);
		map.put("size", bTypes.size());
		for(int i=0;i<bTypes.size();i++)
		{
			map.put("bType"+i, bTypes.get(i));			
		}
		return map;
	}
	
	
}
