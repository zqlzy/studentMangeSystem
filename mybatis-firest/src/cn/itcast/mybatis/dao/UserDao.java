package cn.itcast.mybatis.dao;

import java.util.List;

import cn.itcast.mybatis.pojo.User;

public interface UserDao {
	/**
	 * 根据用户id查询用户
	 * @param id
	 * @return
	 */
	public User selectUserById(Integer id);
	/**
	 * 
	 * @param username
	 * @return
	 */
	List<User> queryUserByUsername(String username);
	/**
	 * 
	 * @param user
	 */
	void saveUser(User user);
	

}
