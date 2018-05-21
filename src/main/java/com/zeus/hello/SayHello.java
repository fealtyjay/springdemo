package com.zeus.hello;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayHello {
//	@RequestMapping(method=RequestMethod.POST)
//	public String sayHello(@RequestParam(value="user") String username,@RequestParam(value="password") String password) {
//		return "hello spring boot";
//	}
	@RequestMapping(method=RequestMethod.POST)
	public String sayHello(@RequestBody Map<String,Object> reqmap) {
		String user = String.valueOf(reqmap.get("user"));
		String password = String.valueOf(reqmap.get("password"));
		return "hello spring boot "+user+password;
	}
	@RequestMapping(method=RequestMethod.GET)
	public String sayHellowithnull() {
		return "hello spring bootget";
	}
//	@RequestMapping("/index")
//	public ModelAndView  login() {
//		ModelAndView view = new ModelAndView ();
//		view.setViewName("resources/templates/index.html");
//		view.setStatus(HttpStatus.OK);
//		return view;
//	}
	@RequestMapping("/index")
	public String  login() {
//		ModelAndView view = new ModelAndView ();
//		view.setViewName("resources/templates/index.html");
//		view.setStatus(HttpStatus.OK);
		return "index";
	}
}
