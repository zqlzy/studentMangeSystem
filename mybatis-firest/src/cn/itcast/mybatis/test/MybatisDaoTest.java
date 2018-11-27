package cn.itcast.mybatis.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.dao.UserDao;
import cn.itcast.mybatis.dao.UserDaoImpl;
import cn.itcast.mybatis.pojo.User;

public class MybatisDaoTest {
	
	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void before()throws Exception{
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
 sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
	}
	
	@Test
	public void testDao() throws Exception{
		
		UserDao userDao=new UserDaoImpl(sqlSessionFactory);
		User user=userDao.selectUserById(3);
		System.out.println(user);
		
	}
	
}
