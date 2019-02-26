package com.huaxin.ssm.dao;

import java.util.List;
import java.util.Map;

import com.huaxin.ssm.bean.User;

public interface UserMapper {

	
	/**
	 * 通过参数类型是String对象，查询出一个返回类型是map的对象
	 */
	public Map<String,Object> getStringByMap(String id);
	
	/**
	 * add一条数据
	 */
	public int add(User user);
	
	/**
	 * delete 删除一条数据
	 */
	public int delete(String  id);
	
	/**
	 * deleteMore 删除多条数据
	 */
	public int deleteMore(Map<String,Object> map);
	/**
	 * update 修改数据
	 */
	public int update(Map<String,Object> map);
	/**
	 * getAll 不分页查询 
	 */
	public List<User> getAll(Map<String,Object> map);
	
	
	/**
	 * getAllByPage 分页查询 
	 */
	public List<Map<String,Object>> getAllByPage(Map<String,Object> map);
	
	
	/**
	 * getCount 查询总页数
	 */
	public  int getCount(Map<String,Object> map);
	
	
	
	

}
