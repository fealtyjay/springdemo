package com.zeus.hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zeus.bean.User;
import com.zeus.dao.IUserDAO;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value="/users")
public class UserController {
	@Autowired
	private IUserDAO userService;
//	@Autowired
//	private HttpRequest request;
	@ApiOperation(value="获取用户列表",notes="获取所有的用户")
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public List<User> getList(){
		return userService.findAll();
	}
	@ApiOperation(value="获取编码用户",notes="获取名称为参数的用户")
	@RequestMapping(value="/code",method=RequestMethod.POST)
	public User getUserByCode(@RequestParam(value="code") String code) throws Exception {
//		System.out.println(request.getHeaders().getETag());
//		System.out.println(request.getMethod().name());
//		System.out.println(request.getURI().toString());
		if(StringUtils.isEmpty(code)) {
			throw new Exception("编码为空");
		}
		List<User> users = userService.findByuser_code(code);
		return users.get(0);
	}
	@ApiOperation(value="获取名称用户",notes="获取编码为参数的用户")
	@RequestMapping(value="/name",method=RequestMethod.POST)
	public User getUserByName(@RequestParam(value="name")String name) throws Exception {
//		System.out.println(request.getHeaders().getETag());
//		System.out.println(request.getMethod().name());
//		System.out.println(request.getURI().toString());
		if(StringUtils.isEmpty(name)) {
			throw new Exception("编码为空");
		}
		List<User> users = userService.findByuser_name(name);
		return users.get(0);
	}

}
