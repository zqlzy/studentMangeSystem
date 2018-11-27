package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.pojo.User;

public interface UserMapper {
	
	//遵循四个原则 接口+实现类
	//接口方法名==User.xml中Id名
	//
	public User findUserById(Integer id);

}
