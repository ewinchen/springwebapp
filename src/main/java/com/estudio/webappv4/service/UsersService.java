package com.estudio.webappv4.service;

import java.util.List;
import java.util.Map;

import com.estudio.webappv4.domain.Users;

public interface UsersService {
	
	 List<Map<String, Object>> query();
	
	 void insert(Users users);
	 
	 void updateById(Users users, int id);
	 
	 void removeById(int id);
	 
	 List<Map<String, Object>> call();
	 
	 String callback(int i);
	 
	 String inoutCallback(int i, String str);

}
