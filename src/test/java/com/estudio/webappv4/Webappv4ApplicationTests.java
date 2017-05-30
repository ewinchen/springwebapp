package com.estudio.webappv4;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.activation.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.estudio.webappv4.domain.Users;
import com.estudio.webappv4.service.UsersService;
import com.estudio.webappv4.service.impl.UsersServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Webappv4ApplicationTests {
	
	DataSource dataSource;
	
	
	private static final Logger logger = LoggerFactory.getLogger(UsersServiceImpl.class);
	
	@Autowired
	UsersService usersService;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void query() {
		usersService.query();
	}
	
	@Test
	public void insert() {
		Users users = new Users();
		users.setName("Jack");
		users.setSex("Male");
		users.setBirthdate(new Date(new java.util.Date().getTime()));
		users.setWeight(62.3);
		usersService.insert(users);
	}
	
	@Test
	public void update() throws ParseException {
		Users users = new Users();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		users.setName("Jay");
		users.setSex("Male");
		users.setBirthdate(new Date(sdf.parse("1990-01-01").getTime()));
		users.setWeight(70.3);
		usersService.updateById(users, 10);
	}
	
	@Test
	public void delete(){
		usersService.removeById(5);
	}
	
	@Test 
	public void call() {
		List<Map<String, Object>> list  = usersService.call();
		logger.debug(list.toString());
	}
	
	@Test
	public void callback() {
		String str = usersService.callback(3);
		logger.debug(str);
	}
	
	@Test
	public void inoutcallback() {
		String str = usersService.inoutCallback(3, "1");
		logger.debug(str);
	}

}
