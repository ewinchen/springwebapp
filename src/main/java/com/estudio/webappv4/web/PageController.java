package com.estudio.webappv4.web;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Controller 返回的是View、Model或者ModelAndView，而@RestController返回的是Json
 * @author Administrator
 *
 */
@Controller
public class PageController {
	
	@Value("${application.message:Hello World}")
	private String message = "Hello World";

	@RequestMapping("/index")
	public String index(Map<String, Object> model) {
		
		model.put("time", new Date());
		model.put("message", this.message);
		
		return "index";
	}
	
	@RequestMapping("/page")
	public String page(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("page", this.message+" page");
		return "/page/page";
	}


}
