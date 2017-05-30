package com.estudio.webappv4.web;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.estudio.webappv4.domain.Users;
import com.estudio.webappv4.service.UsersService;

@Controller
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	UsersService usersService;
	
	@RequestMapping("/query")
	@ResponseBody
	public List<Map<String, Object>> query() {
		return usersService.query();
	}
	
	@RequestMapping("/response")
	public void response(HttpServletResponse response) throws IOException {
		response.getWriter().write("Hello response");
	}

	@RequestMapping("/write")
	public void write(Writer writer) throws IOException{
		writer.write("Hello write");
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public void addUsers(@RequestBody Users users) {
		usersService.insert(users);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public void updateUsers(@RequestBody Users users) {
		usersService.updateById(users, users.getId());
	}
	
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public void deleteUsers(@PathVariable int id){
		usersService.removeById(id);
	}
	
	
}