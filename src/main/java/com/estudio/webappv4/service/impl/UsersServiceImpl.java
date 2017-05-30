package com.estudio.webappv4.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.estudio.webappv4.domain.Users;
import com.estudio.webappv4.service.UsersService;

@Repository
public class UsersServiceImpl implements UsersService {
	
	private static final Logger logger = LoggerFactory.getLogger(UsersServiceImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Map<String, Object>> query() {
		logger.debug("查询");
		List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from users");
		return list;
	}


	@Override
	public void insert(Users users) {
		logger.debug("新增");
		jdbcTemplate.update("insert into users values(?, ?, ?, ?, ?)", null, users.getName(), users.getSex(), users.getBirthdate(), users.getWeight());
	}

	@Override
	public void updateById(Users users, int id) {
		logger.debug("修改");
		jdbcTemplate.update("update users set name = ?, sex = ?, birthdate = ?, weight = ? where id = ?", users.getName(), users.getSex(), users.getBirthdate(), users.getWeight(), id);
	}

	@Override
	public void removeById(int id) {
		logger.debug("删除");
		jdbcTemplate.update("delete from users where id = ?", id);

	}

	@Override
	public List<Map<String, Object>> call() {
		logger.debug("调用存储过程");
		List<Map<String, Object>> list = jdbcTemplate.queryForList("call findusers");
		return list;
		
	}
	
	@Override
	public String callback(int i) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("inoutsample");
		Map<String, Object> inmap = new HashMap<>();
		inmap.put("a", i);
		//可以用两个方法设置输入的变量，目前不知道有何区别，感觉输入输出都用Map的方式代码简洁统一
//		SqlParameterSource in = new MapSqlParameterSource().addValue("a", i);
		Map<String, Object> map = simpleJdbcCall.execute(inmap);
//		return map.get("b").toString();
		//可以用以下方式获取存储过程中的结果集
		return map.get("#result-set-1").toString();
		
	}
	
	@Override
	public String inoutCallback(int i, String str) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("in_out_inoutsample");
//		Map<String, Object> inmap = new HashMap<>();
//		inmap.put("a", i);
		SqlParameterSource in = new MapSqlParameterSource().addValue("a", i).addValue("c", str);
		Map<String, Object> map = simpleJdbcCall.execute(in);
		return map.get("b").toString() + map.get("c").toString();
	}

}
