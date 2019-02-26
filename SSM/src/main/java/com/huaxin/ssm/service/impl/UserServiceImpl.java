package com.huaxin.ssm.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huaxin.ssm.bean.User;
import com.huaxin.ssm.dao.UserMapper;
import com.huaxin.ssm.service.IUserService;
import com.huaxin.ssm.util.DateUtil;
@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserMapper usermapper;

	@Override
	public Map<String, Object> getStringByMap(String id) {
		return null;
	}

	@Override
	public int add(User user) {
		user.setBirthday(DateUtil.str2SqlDate(user.getBirthdays()));
		return usermapper.add(user);
	}

	@Override
	public int delete(String id) {
		return 0;
	}

	@Override
	public int deleteMore(Map<String, Object> map) {
		return 0;
	}

	@Override
	public int update(Map<String, Object> map) {
		return 0;
	}

	@Override
	public List<User> getAll(Map<String, Object> map) {
		return usermapper.getAll(map);
	}

	@Override
	public List<Map<String, Object>> getAllByPage(Map<String, Object> map) {
		return null;
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return 0;
	}

}
