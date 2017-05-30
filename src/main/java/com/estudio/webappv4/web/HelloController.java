package com.estudio.webappv4.web;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/hello")
public class HelloController {
	
	@RequestMapping
	public String hello() {
//		return "Hello Spring! -with Spring-Boot Yay!";
		return " <html>"+
		" <h1>Hello Spring! -with Spring-Boot Yay!</h1>"+
		" </html>";
	}
	
	@RequestMapping("/time")
	public String Time() {
		return "Time is:" + new Date();
	}
	
	@RequestMapping("/info")
	public Map<String, String> getInfo(@RequestParam String name) {
		Map<String, String> map = new HashMap<>();
		map.put("name", name);
		return map;
	}
	
	@RequestMapping("/list")
	public List<Map<String, String>> getList() {
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> map = null;
		for (int i=1; i<=5; i++) {
			map = new HashMap<>();
			map.put("name", "Edwin-" + i);
			list.add(map);
		}
		return list;
	}
	
	@RequestMapping("/index") 
	public ModelAndView index(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index.jsp");
		return modelAndView;
		
	}

}
